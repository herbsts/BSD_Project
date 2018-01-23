package bsd.school2017.boost_it.pkgAdapter;

/**
 * Created by Martin on 13.10.2017.
 */

public class DataModel {

    String name;
    String description;
    String diff_number;
    String feature;

    public DataModel(String name, String description, String diff_number, String feature ) {
        this.name=name;
        this.description=description;
        this.diff_number=diff_number;
        this.feature=feature;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDiff_number() {
        return diff_number;
    }

    public String getFeature() {
        return feature;
    }

}