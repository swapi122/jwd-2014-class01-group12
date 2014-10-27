package vn.edu.hcmute.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.hcmute.dao.ConceptDAO;
import vn.edu.hcmute.dao.ConceptMapDAO;
import vn.edu.hcmute.dao.NodeDAO;
import vn.edu.hcmute.dao.RelationDAO;
import vn.edu.hcmute.dao.VerticeDAO;
import vn.edu.hcmute.entity.Concept;
import vn.edu.hcmute.entity.ConceptMap;
import vn.edu.hcmute.entity.Node;
import vn.edu.hcmute.entity.Relation;
import vn.edu.hcmute.entity.Vertice;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
/**
 * Servlet implementation class ConceptMapController
 */
@WebServlet("/src/ConceptMapController")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if("save".equals(action)) {
			saveConceptMap(request, response);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("{\"status\":\"Success!!!!\"}");
		} else {
			if("load".equals(action)) {
				loadConceptMap(request, response);
			}
		}
		
	}
	
	private void loadConceptMap(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String conceptMapID = request.getParameter("cmid");
		ConceptMapDAO cmDAO = new ConceptMapDAO();
		ConceptMap conceptMap = cmDAO.getConceptMapByID(conceptMapID);
		PrintWriter out = response.getWriter();
		JsonWriter write = new JsonWriter(out);
		Iterator<Concept> iConcept = conceptMap.getConcepts().iterator();
		Iterator<Relation> iRelation = conceptMap.getRelations().iterator();
		Iterator<Vertice> iVertice = null;
		Concept concept = new Concept();
		Relation relation = new Relation();
		Vertice vertice = new Vertice();
		int z = 1;
		
		write.beginObject();
		write.name("cells");
		write.beginArray();
		while(iConcept.hasNext()) {
			write.beginObject();
			concept = iConcept.next();
			write.name("type").value("basic.Circle");
			write.name("size");
			write.beginObject();
			write.name("width").value(concept.getNode().getWidth());
			write.name("height").value(concept.getNode().getHeight());
			write.endObject();
			write.name("position");
			write.beginObject();
			write.name("x").value(concept.getNode().getX());
			write.name("y").value(concept.getNode().getY());
			write.endObject();
			write.name("angle").value(concept.getNode().getAngle());
			write.name("id").value(concept.getConceptID());
			write.name("z").value(z++);
			write.name("attrs");
			write.beginObject();
			write.name("circle");
			write.beginObject();
			write.name("fill").value(concept.getNode().getBackground());
			write.endObject();
			write.name("text");
			write.beginObject();
			write.name("text").value(concept.getConceptName());
			if(concept.getNode().getFontColor() != null) {
				write.name("fill").value(concept.getNode().getFontColor());
			}
			write.endObject();
			write.endObject();
			write.endObject();
		}
		while(iRelation.hasNext()) {
			write.beginObject();
			relation = iRelation.next();
			write.name("type").value("link");
			write.name("labels");
			write.beginArray();
			write.beginObject();
			write.name("position").value(0.5);
			write.name("attrs");
			write.beginObject();
			write.name("text");
			write.beginObject();
			write.name("text").value(relation.getTitle());
			write.endObject();
			write.endObject();
			write.endObject();
			write.endArray();
			write.name("id").value(relation.getRelationID());
			write.name("embeds").value("");
			write.name("source");
			write.beginObject();
			write.name("id").value(relation.getConcept1().getConceptID());
			write.endObject();
			write.name("target");
			write.beginObject();
			write.name("id").value(relation.getConcept2().getConceptID());
			write.endObject();
			write.name("z").value(z++);
			write.name("vertices");
			write.beginArray();
			List<Vertice> vList = new ArrayList<Vertice>();
			vList = relation.getVertices();
			for(Vertice v:vList) {
				write.beginObject();
				write.name("x").value(v.getX());
				write.name("y").value(v.getY());
				write.endObject();
			}
			write.endArray();
			write.name("attrs");
			write.beginObject();
			write.name(".connection");
			write.beginObject();
			write.name("stroke").value("blue");
			write.endObject();
			write.name(".marker-target");
			write.beginObject();
			write.name("fill").value("yellow");
			write.name("d").value("M 10 0 L 0 5 L 10 10 z");
			write.endObject();
			write.endObject();
			write.endObject();
		}
		
		write.endArray();
		write.endObject();
	}
	
	private void saveConceptMap(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ConceptDAO conceptDAO = new ConceptDAO();
		NodeDAO nodeDAO = new NodeDAO();
		ConceptMap conceptMap = new ConceptMap();
		ConceptMapDAO conceptMapDAO = new ConceptMapDAO();
		Relation relation = new Relation();
		Concept concept = new Concept();
		Node node = new Node();
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();		//Danh sach cac vertice cua 1 relation
		ArrayList<ArrayList<Vertice>> verticelist = new ArrayList<ArrayList<Vertice>>();	//Danh sach tat ca cac vertice cua concept map
		ArrayList<Relation> relations = new ArrayList<Relation>();	//Danh sach tat ca cac relation cua concept map
		
		//Danh sach tat ca cac conceptTarget cua relation dung khi tim duoc 1 relation nhung lai chua co conceptTarget
		ArrayList<String> conceptTargetIDs = new ArrayList<String>();	
		
		String json = request.getParameter("json");
		
		//add concept map
		int numCM = conceptMapDAO.getAllConceptMap().size();
		conceptMap.setConceptMapID("CM"+numCM);
		conceptMap.setConceptMapName("Concept Map "+numCM);
		conceptMapDAO.addConceptMap(conceptMap);
		InputStream in = new ByteArrayInputStream(json.getBytes());
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		reader.beginObject();
		reader.nextName();
			while(reader.hasNext()) {
				reader.beginArray();
					while(reader.hasNext()) {
						reader.beginObject();
							reader.nextName();
							String name = reader.nextString();
							if("basic.Circle".equals(name)) {
								readConcept(reader,concept,node);
								concept.setConceptMap(conceptMap);
								conceptDAO.addConcept(concept);
								node.setConcept(concept);
								nodeDAO.addNode(node);
							} else {
								vertices = new ArrayList<Vertice>();
								relation = new Relation();
								
								conceptTargetIDs.add(readRelation(reader,relation,vertices));
								relations.add(relation);
								verticelist.add(vertices);
								//System.out.println(relation.getTitle());
							}
						reader.endObject();
					}
				reader.endArray();
			}
		reader.endObject();
		
		//add relation va vertice vao db
		addRelations(relations,conceptTargetIDs,conceptMap);
		addVertices(verticelist);	
	}
	private void addRelations(ArrayList<Relation> relations,
			ArrayList<String> conceptTargetIDs, ConceptMap cm) {
		RelationDAO relationDAO = new RelationDAO();
		ConceptDAO conceptDAO = new ConceptDAO();
		Concept concept = new Concept();
		
		//System.out.print(cm.getConceptMapID());
		for(int i=0; i<relations.size(); i++) {
			concept = conceptDAO.getConceptByID(conceptTargetIDs.get(i));
			relations.get(i).setConcept2(concept);
			relations.get(i).setConceptMap(cm);
			relationDAO.addRelation(relations.get(i));
		}
		
		
		/*for(String i: conceptTargetIDs) {
			System.out.println(i);
		}*/
		/*for(Relation r: relations) {
			System.out.println(r.getConcept1());
		}*/
		
	}

	private void readConcept(JsonReader reader,Concept concept, Node node) throws IOException {
		//reader.beginObject();
			while(reader.hasNext()) {
				String name = reader.nextName();
				if("size".equals(name)) {
					reader.beginObject();
						while(reader.hasNext()) {
							String nameSize = reader.nextName();
							if("width".equals(nameSize)) {
								node.setWidth(reader.nextInt());	//set chieu rong cua concept
							}
							else {
								node.setHeight(reader.nextInt());	//set chieu cao cua concept
							}
						}
					reader.endObject();
				} else {
					if("position".equals(name)) {
						reader.beginObject();
							while(reader.hasNext()) {
								String nameP = reader.nextName();
								if("x".equals(nameP)) {
									node.setX(reader.nextInt());	//set toa do x
								} else {
									node.setY(reader.nextInt());	//set toa do y
								}
							}
						reader.endObject();
					} else {
						if("angle".equals(name)) {
							node.setAngle(reader.nextInt());	//set goc xoay
						} else {
							if("id".equals(name)) {	
								String id = reader.nextString();	//set id cho node va concept
								concept.setConceptID(id);
							} else {
								if("z".equals(name)) {
									reader.skipValue();
								} else {
									if("attrs".equals(name)) {
										reader.beginObject();
											while(reader.hasNext()) {
												String attrsName = reader.nextName();
												if("circle".equals(attrsName)) {
													reader.beginObject();
														while(reader.hasNext()) {
															reader.nextName();//chi co 1 key la fill o object nay
															node.setBackground(reader.nextString());
														}
													reader.endObject();
												} else {
													reader.beginObject();
														while(reader.hasNext()) {
															String textName = reader.nextName();
															if("text".equals(textName)) {
																concept.setConceptName(reader.nextString());
															} else {
																node.setFontColor(reader.nextString());
															}
														}
													reader.endObject();
												}
											}
										reader.endObject();
									} else {
										reader.skipValue();
									}
								}
							}
						}
					}
				}
			}
		//reader.endObject();
	}
	
	//Ham tra ve kieu String, moi lan chay se tra ve conceptTarget cua relation
	private String readRelation(JsonReader reader,Relation relation, 
			ArrayList<Vertice> vertices) throws IOException {
		ConceptDAO conceptDAO = new ConceptDAO();
		Concept conceptSource = new Concept();
		Vertice verticeTmp = new Vertice();
		int verticeID=0;
		String conceptTargetID=null;
		
		//reader.beginObject();
			while(reader.hasNext()) {
				String name = reader.nextName();
				if("labels".equals(name)) {
					reader.beginArray();
						while(reader.hasNext()) {
							reader.beginObject();
								while(reader.hasNext()) {
									String labelName = reader.nextName();
									if("position".equals(labelName)) {
										reader.skipValue();
									} else {
										reader.beginObject();
											while(reader.hasNext()) {
												reader.nextName();
												reader.beginObject();
													while(reader.hasNext()) {
														reader.nextName();
														relation.setTitle(reader.nextString()); 	//set title
													}
												reader.endObject();
											}
										reader.endObject();
									}
								}
							reader.endObject();
						}
					reader.endArray();
				} else {
					if("id".equals(name)) {
						String id = reader.nextString();
						relation.setRelationID(id);
					} else {
						if("embeds".equals(name)) {
							reader.skipValue();
						} else {
							if("source".equals(name)) {
								conceptSource = new Concept();
								reader.beginObject();
									while(reader.hasNext()) {										
										reader.nextName();
										conceptSource = conceptDAO.getConceptByID(reader.nextString());
										if(conceptSource != null) {
											relation.setConcept1(conceptSource);
										}									
									}
								reader.endObject();
							} else {
								if("target".equals(name)) {
									reader.beginObject();
									while(reader.hasNext()) {
										reader.nextName();
										conceptTargetID = reader.nextString();
										 //System.out.println(conceptTargetID);
										/*conceptTarget = conceptDAO.getConceptByID(id);
										if(conceptTarget != null) {
											relation.setConcept2(conceptTarget);
										} else {
											conceptTargetID = id;
											System.out.println(conceptTargetID);
										}*/
									}
									reader.endObject();
								} else {
									if("z".equals(name)) {
										reader.skipValue();
									} else {
										if("vertices".equals(name)) {
											
											reader.beginArray();
												while(reader.hasNext()) {
													verticeTmp = new Vertice();
													reader.beginObject();
														while(reader.hasNext()) {
															String vName = reader.nextName();
															if("x".equals(vName)) {
																verticeTmp.setX(reader.nextInt());																
															} else {																
																verticeTmp.setY(reader.nextInt());																
															}															
														}
													verticeTmp.setVerticeID(verticeID++);
													verticeTmp.setRelation(relation);													
													vertices.add(verticeTmp);
													reader.endObject();
												}
											reader.endArray();
										} else {
											reader.skipValue();
										}
									}
								}
							}
						}
					}
				}
			}
		//reader.endObject();
			return conceptTargetID;
	}
	
	//Add danh sach vertical vao db sau moi lan tim duoc 1 relation
	private void addVertices(ArrayList<ArrayList<Vertice>> verticelist) {
		VerticeDAO verticeDAO = new VerticeDAO();
		
		for(ArrayList<Vertice> list: verticelist) {
			if(list!=null) {
				for(Vertice v:list) {
					verticeDAO.addVertice(v);
				}
			}
		}
	}

}
