package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {



    private Map<Long,JournalEntry> journalEntries =new HashMap<>();



    @GetMapping ()
    public List<JournalEntry> getAll(){
         return new ArrayList<>(journalEntries.values());
    }


    @GetMapping ("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable long myId){
        return journalEntries.get(myId);
    }
@PostMapping()
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getID(),myEntry);
        return true;

    }
    @DeleteMapping  ("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable long myId){
        return journalEntries.remove(myId);
    }

@PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable long id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }
}
