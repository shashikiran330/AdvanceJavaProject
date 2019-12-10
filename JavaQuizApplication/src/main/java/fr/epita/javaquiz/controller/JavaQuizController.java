package fr.epita.javaquiz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.javaquiz.dao.JavaQuizDao;
import fr.epita.javaquiz.model.Questions;
import fr.epita.javaquiz.model.Questionaire;

@Controller
public class JavaQuizController {

	@Autowired
	private JavaQuizDao javaQuizDao;

	@RequestMapping(value = "/javatest")
	public ModelAndView addQuestions(HttpServletRequest request) {
		
		List<Questions> questions = getQuestionsData();
		List<Questionaire> quizQuestList = new ArrayList<Questionaire>();

		if(questions != null && !questions.isEmpty()) {
			for (Questions question : questions) {
				String[] choiceList = new String[] { question.getAnswer1(), question.getAnswer2(), question.getAnswer3(), question.getAnswer4() };
				Questionaire quizQuest =  new Questionaire();
				quizQuest.setQuestionaire(question.getQuestion());
				quizQuest.setChoiceList(choiceList);
				quizQuest.setCorrectAnswer(question.getCorrect());
				quizQuestList.add(quizQuest);
			}
			
			javaQuizDao.persist(quizQuestList);
			
		}
		
		return new ModelAndView("javatest.jsp", "javaQuizDao", javaQuizDao);
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView load(HttpServletRequest request) {
		return new ModelAndView("login.jsp", "javaQuizDao", javaQuizDao);
		
	}
	
	@RequestMapping(value = "/questions")
	public ModelAndView finishQuiz(HttpServletRequest request) {
		int total = 0;
		String[] questionIds = request.getParameterValues("questionId");
		for(String qId: questionIds) {
			System.out.println(qId);
			String correctAnswer = javaQuizDao.getCorrectAnswer(Integer.parseInt(qId));
			if(correctAnswer != null && correctAnswer.equals(request.getParameter("question_" + qId))) {
				total++;
			}
		}
		
		request.setAttribute("total", total);
		return new ModelAndView("javatest.jsp", "javaQuizDao", javaQuizDao);
	}
	
	public List<Questions> getQuestionsData() {
		File xmlFile = new File(this.getClass().getClassLoader().getResource("questions.xml").getFile());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
        List<Questions> questList = new ArrayList<Questions>();
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("question");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
            	questList.add(getQuestion(nodeList.item(i)));
            }
            
            for (Questions quest : questList) {
                System.out.println(quest.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        
        return questList;
	}
	
	private static Questions getQuestion(Node node) {
        Questions quest = new Questions();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            quest.setQuestion(getTagValue("quizquestion", element));
            quest.setAnswer1(getTagValue("answer1", element));
            quest.setAnswer2(getTagValue("answer2", element));
            quest.setAnswer3(getTagValue("answer3", element));
            quest.setAnswer4(getTagValue("answer4", element));
            quest.setCorrect(getTagValue("correct", element));
        }

        return quest;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
