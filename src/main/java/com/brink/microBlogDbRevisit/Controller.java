package com.brink.microBlogDbRevisit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    MessageRepo messageRepo;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (List <Message>)  messageRepo.findAll();
        model.addAttribute("messageRepo", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String text) {
        Message message = new Message(text);
        messageRepo.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(Integer id) {
        messageRepo.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String edit(Model model, Integer id) {
        Message message = messageRepo.findOne(id);
        model.addAttribute("messageRepo", message);
        return "edit";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(String text, Integer id) {
        Message message = new Message(id, text);
        messageRepo.save(message);
        return "redirect:/";
    }

}
