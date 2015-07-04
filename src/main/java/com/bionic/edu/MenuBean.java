package com.bionic.edu;


import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named
@Scope("request")
public class MenuBean implements Serializable{

	private Menu menu;
	private UploadedFile file;
	private List <Menu> menuList;
	
	@Inject
	private MenuService menuService;

	public MenuBean() {		
		menu = new Menu();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
		
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}	
	
	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String saveMenu(){		
		menuService.add(menu);
		return "addDish";
	}
	
	@PostConstruct
	public void refreshList(){			
		menuList = menuService.getMenuList();		
	}	
	
	
	public String addCover(){
	     // idBZ - Идентификатор файла изображения
	/*String fileId = "../" + idBZ + ".jpg";
	File inpt = new File(fileId);
	if (!inpt.exists()){
		String fileMsg = "Не найден файл " + fileId;
		return "AddCover"; 
	}*/
	   	     
	     try{
	    	 FileInputStream in = (FileInputStream) file.getInputstream();	 
	    	 // Чтение изображения из файла
	    	 byte[] img = new byte[(int)((File) file).length()];    	    	 
	    	 in.read(img);
	    	 in.close();
	    	 menu=menuService.findById(7);
	    	 menu.setCover(img);
	    	 menuService.editMenu(menu);
	    	 } catch (Exception e){ System.out.println(e.getMessage());}
	    	     return "BookDetail"; 
		}	
	
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Dish Edited", ((Menu)event.getObject()).getDishName());        		
        FacesContext.getCurrentInstance().addMessage(null, msg);
        DataTable table = (DataTable) event.getSource();
        Menu m = (Menu) table.getRowData();
        menuService.editMenu(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully Updated"));  
    }    
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Menu)event.getObject()).getDishName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
  
}
