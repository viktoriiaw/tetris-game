package com.tetris;

public class Фигура_L extends Фигура {

    private Field field;
    private boolean фигураНеПеревернута = true;

    public Фигура_L(Field field) {
        координата = new Координата[4];
        координата[0] = new Координата(0, 5);
        координата[1] = new Координата(1, 5);
        координата[2] = new Координата(2, 5);
        координата[3] = new Координата(2, 6);

        this.field = field;
        двигатьсяВниз();
    }

    @Override
    public void перевернуть() {
        if (фигураНеПеревернута) {
            Координата[] новаяКоордината = new Координата[4];
            новаяКоордината[0] = new Координата(this.координата[0].getX() + 1, this.координата[0].getY() - 1);
            новаяКоордината[1] = new Координата(this.координата[1].getX(), this.координата[1].getY());
            новаяКоордината[2] = new Координата(this.координата[2].getX() - 1, this.координата[2].getY() + 1);
            новаяКоордината[3] = new Координата(this.координата[3].getX() - 2, this.координата[3].getY());
            this.координата = field.moveToPosition(новаяКоордината, this.координата, 'Z');
            this.фигураНеПеревернута = false;
        } else {
            Координата[] новаяКоордината = new Координата[4];
            новаяКоордината[0] = new Координата(this.координата[0].getX() - 1, this.координата[0].getY() + 1);
            новаяКоордината[1] = new Координата(this.координата[1].getX(), this.координата[1].getY());
            новаяКоордината[2] = new Координата(this.координата[2].getX() + 1, this.координата[2].getY() - 1);
            новаяКоордината[3] = new Координата(this.координата[3].getX() + 2, this.координата[3].getY());
            this.координата = field.moveToPosition(новаяКоордината, this.координата, 'Z');
            this.фигураНеПеревернута = true;
        }
    }

    @Override
    public void двигатьсяВниз() {
        Координата[] новаяКоордината = new Координата[4];
        новаяКоордината[0] = new Координата(this.координата[0].getX() + 1, this.координата[0].getY());
        новаяКоордината[1] = new Координата(this.координата[1].getX() + 1, this.координата[1].getY());
        новаяКоордината[2] = new Координата(this.координата[2].getX() + 1, this.координата[2].getY());
        новаяКоордината[3] = new Координата(this.координата[3].getX() + 1, this.координата[3].getY());
        this.координата = field.moveToPosition(новаяКоордината, this.координата, 'Z');
    }

    @Override
    public void двигатьсяВправо() {
        Координата[] новаяКоордината = new Координата[4];
        новаяКоордината[0] = new Координата(this.координата[0].getX(), this.координата[0].getY() + 1);
        новаяКоордината[1] = new Координата(this.координата[1].getX(), this.координата[1].getY() + 1);
        новаяКоордината[2] = new Координата(this.координата[2].getX(), this.координата[2].getY() + 1);
        новаяКоордината[3] = new Координата(this.координата[3].getX(), this.координата[3].getY() + 1);
        this.координата = field.moveToPosition(новаяКоордината, this.координата, 'Z');
    }

    @Override
    public void двигатьсяВлево() {
        Координата[] новаяКоордината = new Координата[4];
        новаяКоордината[0] = new Координата(this.координата[0].getX(), this.координата[0].getY() - 1);
        новаяКоордината[1] = new Координата(this.координата[1].getX(), this.координата[1].getY() - 1);
        новаяКоордината[2] = new Координата(this.координата[2].getX(), this.координата[2].getY() - 1);
        новаяКоордината[3] = new Координата(this.координата[3].getX(), this.координата[3].getY() - 1);
        this.координата = field.moveToPosition(новаяКоордината, this.координата, 'Z');
    }
}
