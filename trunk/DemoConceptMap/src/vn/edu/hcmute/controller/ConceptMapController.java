package vn.edu.hcmute.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import vn.edu.hcmute.dao.ConceptDAO;
import vn.edu.hcmute.dao.ConceptMapDAO;
import vn.edu.hcmute.dao.RelationDAO;
import vn.edu.hcmute.entity.Concept;
import vn.edu.hcmute.entity.ConceptMap;
import vn.edu.hcmute.entity.Relation;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
/**
 * Servlet implementation class ConceptMapController
 */
@WebServlet("/ConceptMapController")
public class ConceptMapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConceptMapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConceptMap cm = new Gson().fromJson(request.getParameter("cm"), ConceptMap.class);
		//String json ="{Relations:}"
		Relation relation;
		Concept concept1;
		Concept concept2;
		Concept temp;
		ConceptMapDAO cmDAO=new ConceptMapDAO();
		ConceptDAO conceptDAO = new ConceptDAO();
		RelationDAO relationDAO = new RelationDAO();
		int numberRelation = cm.getRelationList().size();
		int id=0;
		//HashMap<Integer, String> conceptTable=new HashMap<Integer, String>();
		List<Concept> listConcept=new ArrayList<Concept>();
		try {
			cmDAO.addConceptMap(cm);
			for (int i=0; i<numberRelation; i++) {
				concept1 = new Concept();
				concept2 = new Concept();
				temp=new Concept();
				relation = new Relation();
				
				concept1 = cm.getRelationList().get(i).getConcept1();
				concept2 = cm.getRelationList().get(i).getConcept2();
				temp=checkExistConcept(concept1.getConceptName(),listConcept);
				
				if(temp!=null){
					//Da ton tai
					concept1=temp;
				}
				else {
					//Chua ton tai thi them vao db
					concept1.setConceptID(conceptDAO.addConcept(concept1));
					listConcept.add(concept1);
				}
				
				temp=checkExistConcept(concept2.getConceptName(),listConcept);
				if(temp!=null){
					concept2=temp;
				}
				else{
					concept2.setConceptID(conceptDAO.addConcept(concept2));
					listConcept.add(concept2);
				}
				
				relation.setConcept1(concept1);
				relation.setConcept2(concept2);
				relation.setConceptMap(cm);
				relationDAO.addRelation(relation);
			}
		} catch(Exception e){
			response.getWriter().write(e.getMessage());
		}
		response.getWriter().write("Luu thanh cong");
	}
	
	public Concept checkExistConcept(String name,List<Concept> list){
		for (Concept concept : list) {
			if(concept.getConceptName().equals(name)){
				return concept;
			}
		}
		return null;
		
	}

}
