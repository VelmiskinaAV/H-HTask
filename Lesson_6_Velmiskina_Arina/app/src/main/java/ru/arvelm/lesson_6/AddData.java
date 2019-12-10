package ru.arvelm.lesson_6;

public class AddData {
    public int image;
    public String title;
    public String info;
    public String ID;
    public Boolean redTextFlag;
    public int imageAlert;
    public int type;

    AddData(int type, int image, String title, String ID, int imageAlert, String info, Boolean redTextFlag){

        this.type = type;
        this.image = image;
        this.title = title;
        this.ID = ID;
        this.info = info;
        this.imageAlert = imageAlert;
        this.redTextFlag = redTextFlag;
    }

    public String getTitle(){ return title; }

    public String getInfo(){ return info; }

    public Boolean getRedTextFlag() { return redTextFlag; }

    public int getType() { return type; }

    public int getImageAlert() { return imageAlert; }

    public String getID() { return ID; }

    public int getImage() {
        return image;
    }
}
