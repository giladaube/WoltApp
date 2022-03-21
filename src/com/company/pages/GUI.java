package com.company.pages;

import com.company.pages.IPage;

public class GUI {
    private IPage page;
    public void show(){
        page.showPage();
    }
    public void setPage(IPage page){
        this.page = page;
    }
}
