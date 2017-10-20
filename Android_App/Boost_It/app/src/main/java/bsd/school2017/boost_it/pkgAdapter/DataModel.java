package bsd.school2017.boost_it.pkgAdapter;

/**
 * Created by Martin on 13.10.2017.
 */

public class DataModel {

    public int icon;
    public String name;

    // Constructor.
    public DataModel(int icon, String name) {

        this.icon = icon;
        this.name = name;
    }

    public DataModel(String name){
        this.name = name;
    }
}