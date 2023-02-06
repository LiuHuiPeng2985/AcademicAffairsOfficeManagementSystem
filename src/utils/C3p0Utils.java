package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3p0Utils {
    private static DataSource ds = null;
    static {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("itcast");
        ds = comboPooledDataSource;
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
