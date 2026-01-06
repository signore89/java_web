package org.ee.jakarta.musik.dao;

import org.ee.jakarta.musik.entity.Singer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingerDao {
    private Connection con;

    public SingerDao(Connection con) {
        this.con = con;
    }

    public List<Singer> getAllSingers() throws SQLException {
        List<Singer> artists = new ArrayList<>();
        String sql = "SELECT \"Id\", \"Name\", \"UrlImg\" FROM \"Artists\" ORDER BY \"Name\"";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Singer artist = new Singer();
                artist.setId(rs.getInt("Id"));
                artist.setName(rs.getString("name"));
                artist.setUrlImg(rs.getString("urlImg"));
                artists.add(artist);
            }
        }
        return artists;
    }
}
