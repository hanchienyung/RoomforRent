package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static java.lang.Long.parseLong;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class RoomController {

    @Autowired
    RoomRepository roomRepository;


    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("rooms", roomRepository.findRoomByPrivte(Boolean.FALSE));
        return "mainpage";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/logout")
    public String secure(){
        return "mainpage";
    }

    @RequestMapping("/listroom")
    public String listroomForm(Model model) {
        if (sec:authorize="isAuthenticated()")
        {
           model.addAttribute("rooms", roomRepository.findAll());
        }

        else {

           model.addAttribute("rooms", roomRepository.findRoomByPrivte(Boolean.FALSE));
    }
        return "listroom";
    }

    @RequestMapping("/listprivroom")
    public String listprivateroomForm(Model model) {
        model.addAttribute("rooms", roomRepository.findRoomByPrivte(Boolean.TRUE));
        return "listroom";
    }


    @RequestMapping("/addroom")
    public String roomForm(Model model) {
        model.addAttribute("room", new Room());
        return "addroomform";
    }

    @RequestMapping("/detailroom")
    public String detailForm(Model model) {
        model.addAttribute("room", new Room());
        return "detailroomform";
    }

    @RequestMapping("/rentroom")
    public String rentroomForm(Model model) {
        model.addAttribute("rooms", roomRepository.findRoomByRented(Boolean.FALSE));
        return "rentroomform";
    }

    @RequestMapping("/returnroom")
    public String returnroomForm(Model model) {
        model.addAttribute("rooms", roomRepository.findRoomByRented(Boolean.TRUE));
        return "returnroomform";
    }


    @RequestMapping(value="/processrent", params={"id"}, method=GET)
    public String processrentForm( @RequestParam("id") String id, Model model)
    {
        //System.out.println("Entering processrentform id = " +id);
        List <Room> rooms = roomRepository.findRoomById(Long.parseLong(id));
        for (Room room: rooms) {
            room.setRented(Boolean.TRUE);
            roomRepository.save(room);
        }

      /*  if (result.hasErrors()){
            return "rentroomform";
        }*/
        return "msgrented";
        //return "redirect:/";
    }


    @PostMapping("/processadd")
    public String processaddForm(@Valid Room room, BindingResult result)
    {
        //System.out.println("Entering processaddform room = " + room.getAddress());
        //System.out.println(" processaddform result = " + result.toString());
        if (result.hasErrors()){
            return "addroomform";
        }
        // if (room.getImage().isEmpty()){
        //     room.setImage("http://moziru.com/images/cover-clipart-school-book-5.jpg");
        // }
        //System.out.println("Before saving processaddform result = " + result.toString());
        roomRepository.save(room);
        return "redirect:/";
    }

    @RequestMapping(value="/processdetail", params=("id"), method=GET)
    public String processdetailForm(@RequestParam("id") String id, Model model)
    {
        //System.out.println("Entering processaddform room = " + room.getAddress());
        //System.out.println(" processaddform result = " + result.toString());
        //List <Room> rooms = roomRepository.findRoomById(Long.parseLong(id));
        model.addAttribute("rooms", roomRepository.findRoomById(Long.parseLong(id)));
        return "detailroomform";

        // if (room.getImage().isEmpty()){
        //     room.setImage("http://moziru.com/images/cover-clipart-school-book-5.jpg");
        // }
        //System.out.println("Before saving processaddform result = " + result.toString());

    }



    @RequestMapping(value="/processreturn", params={"id"}, method=GET)
    public String processreturnForm(@RequestParam("id") String id, Model model)
    {
        List <Room> rooms = roomRepository.findRoomById(Long.parseLong(id));
        for (Room room: rooms) {
            room.setRented(Boolean.FALSE);
            roomRepository.save(room);

        }
       /* if (result.hasErrors()){
            return "returnbookform";
        }
        bookRepository.save(book); */
        return "msgreturn";
        //return "redirect:/";
    }


}

