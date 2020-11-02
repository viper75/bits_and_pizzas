package org.viper75.bits_and_pizzas;

public class Pizza {

    private String caption;
    private int imageResource;

    public static final Pizza[] PIZZAS = {
            new Pizza("Diavolo", R.drawable.diavolo),
            new Pizza("Funghi", R.drawable.funghi)
    };

    public Pizza(String caption, int imageResource) {
        this.caption = caption;
        this.imageResource = imageResource;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
