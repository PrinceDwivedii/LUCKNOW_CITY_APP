package com.r.pqr.HelperClasses.homeAdapter;

public class CategoryHelperClass {

    static int image;
    static String title;


    public CategoryHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        }

    public static int getImage() {
        return image;
    }

    public static String getTitle() {
        return title;
    }


}
