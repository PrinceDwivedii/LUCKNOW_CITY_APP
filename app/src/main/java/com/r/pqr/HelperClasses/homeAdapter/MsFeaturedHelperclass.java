package com.r.pqr.HelperClasses.homeAdapter;

import android.widget.TextView;

public class MsFeaturedHelperclass {

    int image;
    String title, description;

    public MsFeaturedHelperclass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
