package com.example.database.chatwithbackend.templates;

import com.example.database.chatwithbackend.common.DatabaseManager;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemplatesDbManager extends DatabaseManager<Template> {

    public List<Template> getTemplates() {
        try {
            List<Template> templates = runQuery("SELECT * FROM Template");
            return templates;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected List<Template> convertToObject(ResultSet resultSet) throws SQLException {
        List<Template> templates = new ArrayList<>();
        while (resultSet.next()) {
            Template template = new Template();
            template.templateId = resultSet.getInt(1);
            template.name = resultSet.getString(2);
            template.messageText = resultSet.getString(3);
            templates.add(template);
        }
        return templates;
    }
}
