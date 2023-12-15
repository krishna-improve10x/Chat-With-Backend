package com.example.database.chatwithbackend.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    @Autowired
    TemplatesDbManager templatesDbManager;

    public List<Template> getTemplates() {
        return templatesDbManager.getTemplates();
    }

    public int updateTemplate(int templateId, String messageText) {
        return templatesDbManager.updateTemplate(templateId,messageText);
    }

    public void deleteTemplate(int templateId){
        templatesDbManager.deleteTemplate(templateId);
    }
}
