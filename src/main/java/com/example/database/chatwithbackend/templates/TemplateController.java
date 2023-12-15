package com.example.database.chatwithbackend.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @GetMapping(value = "listOfTemplates", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Template> getTemplates() {
        return templateService.getTemplates();
    }

    @PutMapping(value = "updateTemplate/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateTemplate(@PathVariable("id") int templateId, @RequestParam String messageText){
        return templateService.updateTemplate(templateId, messageText);
    }

    @DeleteMapping(value = "deleteTemplate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTemplate(@PathVariable("id") int templateId){
        templateService.deleteTemplate(templateId);
    }
}
