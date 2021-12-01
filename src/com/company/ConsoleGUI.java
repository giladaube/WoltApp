package com.company;

import com.company.pages.IPage;

public class ConsoleGUI {
    private IPage page;
    public void show(){
        page.showPage();
    }
    public void setPage(IPage page){
        this.page = page;
    }
}
