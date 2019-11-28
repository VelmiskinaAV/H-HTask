package ru.arvelm.lesson_4;

public class AddData {

    public int image;
    public String title;
    public String info;
    public Boolean redTextFlag;
    public int type;

    AddData(int type, int image, String title, String info, Boolean redTextFlag){

        this.type = type;
        this.image = image;
        this.title = title;
        this.info = info;
        this.redTextFlag = redTextFlag;
    }

    public String getTitle(){
        return title;
    }

    public String getInfo(){
        return info;
    }

    public Boolean getRedTextFlag() { return redTextFlag; }

    public int getType() { return type; }

    public int getImage() {
        return image;
    }
}
