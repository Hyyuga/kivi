/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.common.model;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.mapping.DolphinBean;

/**
 *
 * @author Steppo
 */
@DolphinBean
public class MasterModel {
    
//    private TreeView<String> treeViewMenu;
//    
//    public TreeView<String> treeViewMenu(){
//        return treeViewMenu;
//    }
//    
//    public void setTreeview(TreeView<String> treeView){
//        this.treeViewMenu = treeView;
//    }
    
//    private MenuList menuList;
//    
//    public MenuList menuList(){
//        return menuList;
//    }
//    
//    public void setMenuList(MenuList menuList){
//        this.menuList = menuList;
//    }
    
//    private ListView<MenuItem> menuItems;
//
//    public ListView<MenuItem> getMenuItems() {
//        if(menuItems == null)
//            return new ListView<>();
//        return menuItems;
//    }
    
    private ObservableList<MenuItem> menuItems;

    public ObservableList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
