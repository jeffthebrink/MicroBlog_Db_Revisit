package com.brink.microBlogDbRevisit;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    MessageRepo messageRepo;
}
