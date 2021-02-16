package domaine.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 










import javax.servlet.http.Part;

import dao.IProduitDao;
import dao.IUtilisateurDao;
import dao.ProduitDaoImp;
import dao.UtilisateurDaoImp;
 
import dao.VoteProduitDaoImp;
import domaine.classes.AES;
import domaine.classes.Produit;
import domaine.classes.Token;
import domaine.classes.Utilisateur;
import domaine.classes.VoteProduit;
import domaine.service.SProduit;
import domaine.service.SUtilisateur;
@WebServlet("/upload")
@MultipartConfig
public class ControleurServlet extends HttpServlet{

	private IProduitDao metier;
	private Utilisateur utilisateur;
 
	
	public void init() throws ServletException {
		 metier = new ProduitDaoImp();
		 utilisateur = new Utilisateur();
		 

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getServletPath();
		 
		 if(path.equals("/index.asp"))
		 {
			 String inputValue = "";
			 ProduitModel model = new ProduitModel();
			 model.setIntituleSearched(inputValue);
			 List<Produit> produits = metier.Search("%"+inputValue+"%");
			 model.setListeProduit((ArrayList<Produit>) produits);
			 request.setAttribute("model", model);
			 SProduit sp = new SProduit();
			 sp.updateNbrVoteForAll();
			
			 request.getRequestDispatcher("Home.jsp").forward(request, response);
			  

		 }
		 else if(path.equals("/about.asp"))
		 {
			 
		 }
		 else if(path.equals("/Register.asp"))
		 {
			 request.getRequestDispatcher("Register.jsp").forward(request, response);

			 
		 }
		 else if(path.equals("/saveUtilisateur.asp") && request.getMethod().equals("POST"))
		 {
			 SUtilisateur su = new SUtilisateur();
			 Boolean passwordCheckMetier = false;
			
			 String nom = request.getParameter("nom");
			 String prenom = request.getParameter("prenom");
			 String email = request.getParameter("email");
			 String password = request.getParameter("password");
			 String cpassword =request.getParameter("cpassword");
			 String ville = request.getParameter("ville");
			 if(!su.checkEmailExist(email))
			 {
				 if(password.equals(cpassword))
				 {
					 UtilisateurDaoImp UDI = new UtilisateurDaoImp();
					 Token T = new Token();
					 AES cryp = new AES();
					 String salt = T.generate();
					 String hashedPassword = AES.encrypt(password, salt);
					 Utilisateur U = new Utilisateur(nom, prenom, email, password, 0 ,salt,ville );
					 if( U.getPassword()!= null && U.getPassword().length()>8)
					 {
						 UDI.save(new Utilisateur(nom, prenom, email, hashedPassword, 0 ,salt,ville ));
						 passwordCheckMetier=true;
						 String msgGeneral = "Création faite avec succée ";
							String msgLink = "Cliquer sur ce lien pour retourner a la page Login";
							String targetLink = "Login.jsp";
							
							request.setAttribute("msgGeneral", msgGeneral);
							request.setAttribute("targetLink", targetLink);
							request.setAttribute("msgLink", msgLink);
							request.getRequestDispatcher("ConfirmUtilisateur.jsp").forward(request, response);
					 }
					 else 
					 {
						 
								String msgGeneral = " Le mot de passe doit avoir 8 char en minimum ";
								String msgLink = "Cliquer sur ce lien pour retourner a la page de Register";
								String targetLink = "Register.jsp";
								
								request.setAttribute("msgGeneral", msgGeneral);
								request.setAttribute("targetLink", targetLink);
								request.setAttribute("msgLink", msgLink);
								request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
					 }
							 
				 
					 
					 
				 }
				 else
				 {
					 String msgGeneral = " Le mot de passe doit correspond a mot de passe de la confirmation ";
						String msgLink = "Cliquer sur ce lien pour retourner a la page de Register";
						String targetLink = "Register.jsp";
						
						request.setAttribute("msgGeneral", msgGeneral);
						request.setAttribute("targetLink", targetLink);
						request.setAttribute("msgLink", msgLink);
						request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
				 }
			 }
			 else
			 {
				 String msgGeneral = "L'e-mail que vous avez saisi existe déjà";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de Login";
					String targetLink = "Login.jsp";
					
					request.setAttribute("msgGeneral", msgGeneral);
					request.setAttribute("targetLink", targetLink);
					request.setAttribute("msgLink", msgLink);
					request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
			 }
			
			 
		 }
		 else if(path.equals("/loginUtilisateur.asp") && request.getMethod().equals("POST"))
		 {
			SUtilisateur SU = new SUtilisateur();
			 String email = request.getParameter("email");
			 String password = request.getParameter("password");
			 Utilisateur user = SU.login(email, password) ;
			if(user != null)
			{
				utilisateur.setId(user.getId());
				utilisateur.setNivDroit(user.getNivDroit());
				request.setAttribute("Utilisateur", user);
				request.getRequestDispatcher("Welcome.jsp").forward(request, response);

			}
			else
			{
				String msgGeneral = "Email ou mot de passe incorrect";
				String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
				String targetLink = "Login.jsp";
				
				request.setAttribute("msgGeneral", msgGeneral);
				request.setAttribute("targetLink", targetLink);
				request.setAttribute("msgLink", msgLink);
				request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
			}
			
		 }
		 else if(path.equals("/saveProduct.asp") && request.getMethod().equals("POST"))
		 {
			 if(utilisateur.getId() != 0)
			 {
				if(utilisateur.getNivDroit() != 0)
				{
					 String description = request.getParameter("description");
					 Double prix = Double.parseDouble(request.getParameter("prix"));
					 int qteStock = Integer.parseInt(request.getParameter("qteStock"));
					 String intitule = request.getParameter("intitule");
					 String urlImage = request.getParameter("urlImage");
					 /**/
					 Part part  = request.getPart("urlImage");
					 String fileName = getSubmittedFileName(part);
			 
					 String filePath = ("C:\\Users\\Admin\\workspace\\Brief_Sbahia\\WebContent\\Images"+File.separator+fileName);
				 
							 
					 
					 InputStream is = part.getInputStream();
					 Boolean uploadedImgTest = saveFile(is,filePath);
					 if(uploadedImgTest)
					 {
						 System.out.println("image uploaded");
					 }
					 else
					 {
						 System.out.println("image not uploaded");
					 }
					 
					 Produit P = new Produit (description, prix, qteStock, 0, intitule,fileName );
					 ProduitDaoImp PDI = new ProduitDaoImp();
						
						 
					 if(PDI.save(P) != null)
					 {
						 String msgGeneral = "L'ajout du produit est effectué avec succé";
							String msgLink = "Cliquer sur ce lien pour retourner a la page d'ajout de produit";
							String targetLink = "addProduit.jsp";
							
							request.setAttribute("msgGeneral", msgGeneral);
							request.setAttribute("targetLink", targetLink);
							request.setAttribute("msgLink", msgLink);
							request.getRequestDispatcher("ConfirmProduit.jsp").forward(request, response);
						 
					 }else 
					 {
						 String msgGeneral = "Il existe un probleme dans l'ajout du produit";
							String msgLink = "Cliquer sur ce lien pour retourner a la page d'ajout de produit";
							String targetLink = "addProduit.jsp";
							
							request.setAttribute("msgGeneral", msgGeneral);
							request.setAttribute("targetLink", targetLink);
							request.setAttribute("msgLink", msgLink);
							request.getRequestDispatcher("ErreurProduit.jsp").forward(request, response);
					 }
				}
				else
				{
					 String msgGeneral = "Vous n'avez pas le droit pour accéder à ce service";
						String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
						String targetLink = "Login.jsp";
						
						request.setAttribute("msgGeneral", msgGeneral);
						request.setAttribute("targetLink", targetLink);
						request.setAttribute("msgLink", msgLink);
						request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
				}
			 }
			 else
			 {
				 String msgGeneral = "Vous devriez vous connecter pour accéder à ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					
					request.setAttribute("msgGeneral", msgGeneral);
					request.setAttribute("targetLink", targetLink);
					request.setAttribute("msgLink", msgLink);
					request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
			 }
			
		 }
		 else if(path.equals("/chercher.asp"))
		 {
			 String inputValue = request.getParameter("inputIntitule");
			 ProduitModel model = new ProduitModel();
			 model.setIntituleSearched(inputValue);
			 
			 List<Produit> produits = metier.Search("%"+inputValue+"%");
			  
		 
			  
			 model.setListeProduit((ArrayList<Produit>) produits);
			 
			  
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("actionProduit.jsp").forward(request, response);
			 
		 }
		 else if(path.equals("/addProduit.asp"))
		 {
			 // not working yet
			 if(utilisateur.getId() == 0)
			 {
				 String msgGeneral = "Vous devriez vous connecter pour accéder à ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					
					request.setAttribute("msgGeneral", msgGeneral);
					request.setAttribute("targetLink", targetLink);
					request.setAttribute("msgLink", msgLink);
					request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
				
			 } 
			 if(utilisateur.getNivDroit() == 0)
				{
					String msgGeneral = "Vous n'avez pas le droit pour accéder à ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					
					request.setAttribute("msgGeneral", msgGeneral);
					request.setAttribute("targetLink", targetLink);
					request.setAttribute("msgLink", msgLink);
					request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
					
				} 
			 
		 }
		 else if(path.equals("/modifierArticle.asp"))
		 {
			 int id = Integer.parseInt(request.getParameter("id"));
			 Produit prod = metier.getProduit(id);
			 request.setAttribute("produit", prod);
			 request.getRequestDispatcher("updateProduit.jsp").forward(request, response);

		 }
		 else if(path.equals("/updateProduit.asp") && request.getMethod().equals("POST"))
		 {
			
			 String imgUrl = request.getParameter("imgUrl");
			 int id = Integer.parseInt(request.getParameter("id"));
			 String intitule = request.getParameter("intitule");
			 String description = request.getParameter("description");
			 double prix = Double.parseDouble(request.getParameter("prix"));
			 int qteStock = Integer.parseInt(request.getParameter("qteStock"));
			 SProduit sp = new SProduit();
			 int nbrVote = sp.nbrVoteProduit(id);
			 
			 /**/
			 Part part  = request.getPart("urlImage");
			 String fileName = getSubmittedFileName(part);
	 
			 String filePath = ("C:\\Users\\Admin\\workspace\\Brief_Sbahia\\WebContent\\Images"+File.separator+fileName);
		 
					 
			 
			 InputStream is = part.getInputStream();
			 Boolean uploadedImgTest = saveFile(is,filePath);
			 if(uploadedImgTest)
			 {
				 System.out.println("image uploaded");
			 }
			 else
			 {
				 System.out.println("image not uploaded");
			 }
			 
			 
			 Produit prod = new Produit( description,  prix,  qteStock,  nbrVote ,  intitule ,  fileName);
			 prod.setId(id);
			 System.out.println(prod.toString());
			
			 metier.update(prod);
			 request.setAttribute("produit", prod);
			 request.getRequestDispatcher("ConfirmAction.jsp").forward(request, response);
			 
			 
		 }
		 else if(path.equals("/supprimerArticle.asp"))
		 {
			 int id = Integer.parseInt(request.getParameter("id"));
			 metier.delete(id);
			// request.getRequestDispatcher("article.jsp").forward(request, response);
			 response.sendRedirect("chercher.asp?inputIntitule=");
			 
		 }
		 else if(path.equals("/Vote.asp"))
		 {
			 int idProduit = Integer.parseInt(request.getParameter("id"));
			 int idUtilisateur = utilisateur.getId();

			 VoteProduitDaoImp vpdi = new VoteProduitDaoImp();
			 if(idUtilisateur !=0 )
				 
			 {
				 if(  vpdi.checkVote(new VoteProduit(idProduit, idUtilisateur, null)) != null)
				 {
					 vpdi.save(new VoteProduit(idProduit, idUtilisateur, null));
					 String msgGeneral = "Votre vote a été bien enregister ";
						String msgLink = "Cliquer sur ce lien pour retourner a la page Home";
						String targetLink = "index.asp";
						
						request.setAttribute("msgGeneral", msgGeneral);
						request.setAttribute("targetLink", targetLink);
						request.setAttribute("msgLink", msgLink);
						request.getRequestDispatcher("ConfirmUtilisateur.jsp").forward(request, response);
					
				 }
				 else
				 {
					 String msgGeneral = "Vous avez déja voter pour ce Produit";
						String msgLink = "Cliquer sur ce lien pour retourner a la page Home";
						String targetLink = "index.asp";
						
						request.setAttribute("msgGeneral", msgGeneral);
						request.setAttribute("targetLink", targetLink);
						request.setAttribute("msgLink", msgLink);
						request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
				 }
				 
			 }
			 else
			 {
				 String msgGeneral = "Vous devriez vous connecter pour accéder à ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					
					request.setAttribute("msgGeneral", msgGeneral);
					request.setAttribute("targetLink", targetLink);
					request.setAttribute("msgLink", msgLink);
					request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
			 }
			 
		
			 
			 
		 }
		 else
		 {
			 response.sendError(response.SC_NOT_FOUND);
		 }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
	public Boolean saveFile(InputStream is , String tagetPath)
	{
		Boolean ret = false;
		try 
		{
			byte[] byt = new byte[is.available()];
			is.read(byt);
			FileOutputStream fopt = new FileOutputStream(tagetPath);
			fopt.write(byt);
			fopt.flush();
			fopt.close();
			ret = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ret;
	}
}
