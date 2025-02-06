package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
            journalEntries.put(myEntry.getId(), myEntry);
            return true;
    }
//  To get the entry by ID
    @GetMapping("id/{myId}")
    public JournalEntry journalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

//    To Delete the Entry by Id
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }
//    TO Update the Entry by Id
    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }

}
