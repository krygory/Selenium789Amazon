package com.demo.tests.brokenLinks;

import com.demo.pages.BrokenLinks;
import com.demo.tests.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrokenLinksTest extends BaseTest {



    @Test
    public void findBrokenLinks() {
        try {
            brokenLinks.findBrokenLinks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
