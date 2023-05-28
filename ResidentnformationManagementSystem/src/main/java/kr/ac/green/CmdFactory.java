package kr.ac.green;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.cmd.DoDeleteCmd;
import kr.ac.green.cmd.DoInsertCmd;
import kr.ac.green.cmd.DoModifyCmd;
import kr.ac.green.cmd.FindCmd;
import kr.ac.green.cmd.GetAllCmd;
import kr.ac.green.cmd.ICmd;
import kr.ac.green.cmd.InputCmd;
import kr.ac.green.cmd.ModifyDeleteCmd;
import kr.ac.green.cmd.NodateCmd;


public class CmdFactory {
	
	private static HashMap<String, ICmd> cmds=new HashMap<String, ICmd>();
	
	public static void init() {
		cmds.put("/getAll.resident", new GetAllCmd());// /getAll.student
		cmds.put("/modify.resident", new ModifyDeleteCmd());
		cmds.put("/delete.resident", new ModifyDeleteCmd());
		cmds.put("/input.resident", new InputCmd());
		cmds.put("/doInsert.resident", new DoInsertCmd());
		cmds.put("/find.resident", new FindCmd());
		cmds.put("/doModify.resident", new DoModifyCmd());
		cmds.put("/doDelete.resident", new DoDeleteCmd());
		cmds.put("/nodata.resident", new NodateCmd());
		
	}
	
	public static void action(HttpServletRequest request, String cmd) {
		if(!cmds.containsKey(cmd))cmd="/getAll.resident";
		//System.out.println("cmd: "+cmds.get(cmd));
		cmds.get(cmd).action(request);
	}

}
