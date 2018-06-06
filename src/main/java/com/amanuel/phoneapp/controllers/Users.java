package com.amanuel.phoneapp.controllers;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.sarxos.webcam.Webcam;

@Controller
public class Users {
	
	@RequestMapping("/hello")
	public String index() {
		System.out.println("hellloooooo");
		
		return "index";
	}
	@RequestMapping("/picture")
	public String photo(Model model) {
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		try {
			model.addAttribute("image",ImageIO.write(webcam.getImage(), "JPG", new File("firstCapture.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "picPage";
	}
}
