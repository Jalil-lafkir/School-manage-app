package com.example.Database.Separated;


import java.util.ArrayList;

import com.example.models.Module;

public class ModuleTable {


    ArrayList<Module> modules = new ArrayList<Module>();

    public ModuleTable() {}

    public ArrayList<Module> readAllModules() {
       return modules;
    }

    public void createModule(Module module) {
        this.modules.add(module);
    }

    public Module readModule(String id) {
        for (Module module : this.modules) {
            if (module.getId().equals(id)) {
                return module;
            }
        }
        return null;
    }

    public void updateModule(Module module) {
        for (Module dbmodule : this.modules) {
            if (dbmodule.getId().equals(module.getId())) {
                modules.remove(dbmodule);
                modules.add(module);
                return;
            }
        }
    }

    public void deleteModule(Module module) {
        for (Module dbmodule : this.modules) {
            if (dbmodule.getId().equals(module.getId())) {
                modules.remove(dbmodule);
                return;
            }
        }
    }
    
    
}
