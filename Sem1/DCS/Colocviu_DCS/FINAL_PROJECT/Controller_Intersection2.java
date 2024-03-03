package FINAL_PROJECT;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataTransfer;
import DataObjects.DataString;
import DataObjects.DataInteger;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Controller_Intersection2 {

	public static void main (String []args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Controller";
		pn.SetName("Controller");
		pn.NetworkPort = 1083;
		
		DataString ini = new DataString();
		//ini.Printable = false;
		ini.SetName("ini");
		ini.SetValue("red");
		pn.ConstantPlaceList.add(ini);
		
		DataString red = new DataString();
		//red.Printable = false;
		red.SetName("red");
		red.SetValue("red");
		pn.ConstantPlaceList.add(red);
		
		DataString green = new DataString();
		//green.Printable = false;
		green.SetName("green");
		green.SetValue("green");
		pn.ConstantPlaceList.add(green);
		
		DataString yellow = new DataString();
		//yellow.Printable = false;
		yellow.SetName("yellow");
		yellow.SetValue("yellow");
		pn.ConstantPlaceList.add(yellow);
		
		DataString in1 = new DataString();
		in1.SetName("in1");
		pn.PlaceList.add(in1);
		
		DataString in2 = new DataString();
		in2.SetName("in2");
		pn.PlaceList.add(in2);
		
		DataString in3 = new DataString();
		in3.SetName("in3");
		pn.PlaceList.add(in3);

		DataInteger Five = new DataInteger();
        Five.SetName("Five");
        Five.SetValue(5);
        pn.ConstantPlaceList.add(Five);
        
        DataInteger Ten = new DataInteger();
        Ten.SetName("Ten");
        Ten.SetValue(10);
        pn.ConstantPlaceList.add(Ten);

        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost", "1082" , "P_TL1");
		pn.PlaceList.add(OP1);
		
		DataTransfer OP2 = new DataTransfer();
		OP2.SetName("OP2");
		OP2.Value = new TransferOperation("localhost", "1082" , "P_TL2");
		pn.PlaceList.add(OP2);
		
		DataTransfer OP3 = new DataTransfer();
		OP3.SetName("OP3");
		OP3.Value = new TransferOperation("localhost", "1082" , "P_TL3");
		pn.PlaceList.add(OP3);
		
		//-------------------
		DataString r1r2r3 = new DataString();
		r1r2r3.SetName("r1r2r3");
		r1r2r3.SetValue("signal");
		pn.PlaceList.add(r1r2r3);
		
		DataString g1r2r3 = new DataString();
		g1r2r3.SetName("g1r2r3");
		pn.PlaceList.add(g1r2r3);
		
		DataString r1g2r3 = new DataString();
		r1g2r3.SetName("r1g2r3");
		pn.PlaceList.add(r1g2r3);
		
		DataString r1r2g3 = new DataString();
		r1r2g3.SetName("r1r2g3");
		pn.PlaceList.add(r1r2g3);
		
		DataString r1r2y3 = new DataString();
		r1r2y3.SetName("r1r2y3");
		pn.PlaceList.add(r1r2y3);
		
		DataString y1r2r3 = new DataString();
		y1r2r3.SetName("y1r2r3");
		pn.PlaceList.add(y1r2r3);
		
		DataString r1y2r3 = new DataString();
		r1y2r3.SetName("r1y2r3");
		pn.PlaceList.add(r1y2r3);
		
		
		//----------------------------Tini------------------------------------
		PetriTransition Tini = new PetriTransition(pn);
		Tini.TransitionName = "Tini";
		
		Condition TiniCt1 = new Condition(Tini, "ini", TransitionCondition.NotNull);

		GuardMapping grdTini = new GuardMapping();
		grdTini.condition= TiniCt1;
		
		grdTini.Activations.add(new Activation(Tini, "ini", TransitionOperation.SendOverNetwork, "OP1"));
		grdTini.Activations.add(new Activation(Tini, "ini", TransitionOperation.SendOverNetwork, "OP2"));
		grdTini.Activations.add(new Activation(Tini, "ini", TransitionOperation.SendOverNetwork, "OP3"));
		grdTini.Activations.add(new Activation(Tini, "", TransitionOperation.MakeNull, "ini"));
		
		Tini.GuardMappingList.add(grdTini);
	
		Tini.Delay = 0;
		pn.Transitions.add(Tini);
		
		//----------------------------T1------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "T1";
		t1.InputPlaceName.add("r1r2r3");
		
		Condition T1Ct1 = new Condition(t1, "r1r2r3", TransitionCondition.NotNull);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition= T1Ct1;
		grdT1.Activations.add(new Activation(t1, "r1r2r3", TransitionOperation.Move, "g1r2r3"));
		grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
		t1.GuardMappingList.add(grdT1);
	
		t1.Delay = 5;
		pn.Transitions.add(t1);
				
		//----------------------------T2------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "T2";
		t2.InputPlaceName.add("g1r2r3");
		t2.InputPlaceName.add("in1");
		
		Condition T2Ct1 = new Condition(t2, "g1r2r3", TransitionCondition.NotNull);
		Condition T2Ct2 = new Condition(t2, "in1", TransitionCondition.IsNull);
		T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);
		
		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition= T2Ct1;
		grdT2.Activations.add(new Activation(t2, "g1r2r3", TransitionOperation.Move, "y1r2r3"));
		grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
	//-- Added activation of Five
		grdT2.Activations.add(new Activation(t2, "Five", TransitionOperation.DynamicDelay,""));
		
		t2.GuardMappingList.add(grdT2);
		
		Condition T2Ct3 = new Condition(t2, "g1r2r3", TransitionCondition.NotNull);
		Condition T2Ct4 = new Condition(t2, "in1", TransitionCondition.NotNull);
		T2Ct3.SetNextCondition(LogicConnector.AND, T2Ct4);
		
		GuardMapping grdT21 = new GuardMapping();
		grdT21.condition= T2Ct3;
		grdT21.Activations.add(new Activation(t2, "g1r2r3", TransitionOperation.Move, "y1r2r3"));
		grdT21.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
	//--Added activation of Ten 
		grdT21.Activations.add(new Activation(t2, "Ten", TransitionOperation.DynamicDelay,""));
		
		t2.GuardMappingList.add(grdT21);
	
		t2.Delay = 5;
		pn.Transitions.add(t2);
		
		//----------------------------T3------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "T3";
		t3.InputPlaceName.add("y1r2r3");
		
		Condition T3Ct1 = new Condition(t3, "y1r2r3", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition= T3Ct1;
		grdT3.Activations.add(new Activation(t3, "y1r2r3", TransitionOperation.Move, "r1g2r3"));
		grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
		grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP2"));
				
		t3.GuardMappingList.add(grdT3);
	
		t3.Delay = 5;
		pn.Transitions.add(t3);
		
		//----------------------------T4------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t4.TransitionName = "T4";
		t4.InputPlaceName.add("r1g2r3");
		t4.InputPlaceName.add("in2");
		
		Condition T4Ct1 = new Condition(t4, "r1g2r3", TransitionCondition.NotNull);
		Condition T4Ct2 = new Condition(t4, "in2", TransitionCondition.IsNull);
		T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);
		
		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition= T4Ct1;
		grdT4.Activations.add(new Activation(t4, "r1g2r3", TransitionOperation.Move, "r1y2r3"));
		grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
	//-- Added activation of Five
		grdT4.Activations.add(new Activation(t4, "Five", TransitionOperation.DynamicDelay,""));
		
		t4.GuardMappingList.add(grdT4);
		
		Condition T4Ct3 = new Condition(t4, "r1g2r3", TransitionCondition.NotNull);
		Condition T4Ct4 = new Condition(t4, "in2", TransitionCondition.NotNull);
		T4Ct3.SetNextCondition(LogicConnector.AND, T4Ct4);
		
		GuardMapping grdT41 = new GuardMapping();
		grdT41.condition= T4Ct3;
		grdT41.Activations.add(new Activation(t4, "r1g2r3", TransitionOperation.Move, "r1y2r3"));
		grdT41.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
	//--Added activation of Ten 
		grdT41.Activations.add(new Activation(t4, "Ten", TransitionOperation.DynamicDelay,""));
		
		t4.GuardMappingList.add(grdT41);
	
		t4.Delay = 5;
		pn.Transitions.add(t4);
		
		
		//----------------------------T5------------------------------------
		PetriTransition t5 = new PetriTransition(pn);
		t5.TransitionName = "T5";
		t5.InputPlaceName.add("r1y2r3");
		
		Condition T5Ct1 = new Condition(t5, "r1y2r3", TransitionCondition.NotNull);

		GuardMapping grdT5 = new GuardMapping();
		grdT5.condition= T5Ct1;
		grdT5.Activations.add(new Activation(t5, "r1y2r3", TransitionOperation.Move, "r1r2g3"));
		grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
		grdT5.Activations.add(new Activation(t5, "green", TransitionOperation.SendOverNetwork, "OP3"));
				
		t5.GuardMappingList.add(grdT5);
	
		t5.Delay = 5;
		pn.Transitions.add(t5);
		
		//----------------------------T6------------------------------------
		PetriTransition t6 = new PetriTransition(pn);
		t6.TransitionName = "T6";
		t6.InputPlaceName.add("r1r2g3");
		t6.InputPlaceName.add("in3");
		
		Condition T6Ct1 = new Condition(t6, "r1r2g3", TransitionCondition.NotNull);
		Condition T6Ct2 = new Condition(t6, "in3", TransitionCondition.IsNull);
		T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);
		
		GuardMapping grdT6 = new GuardMapping();
		grdT6.condition= T6Ct1;
		grdT6.Activations.add(new Activation(t6, "r1r2g3", TransitionOperation.Move, "r1r2y3"));
		grdT6.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
	//-- Added activation of Five
		grdT6.Activations.add(new Activation(t6, "Five", TransitionOperation.DynamicDelay,""));
		
		t6.GuardMappingList.add(grdT6);
		
		Condition T6Ct3 = new Condition(t6, "r1r2g3", TransitionCondition.NotNull);
		Condition T6Ct4 = new Condition(t6, "in3", TransitionCondition.NotNull);
		T6Ct3.SetNextCondition(LogicConnector.AND, T6Ct4);
		
		GuardMapping grdT61 = new GuardMapping();
		grdT61.condition= T6Ct3;
		grdT61.Activations.add(new Activation(t6, "r1r2g3", TransitionOperation.Move, "r1r2y3"));
		grdT61.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
	//--Added activation of Ten 
		grdT61.Activations.add(new Activation(t6, "Ten", TransitionOperation.DynamicDelay,""));
		
		t6.GuardMappingList.add(grdT61);
	
		t6.Delay = 6;
		pn.Transitions.add(t6);
		
		
		//----------------------------T7------------------------------------
		PetriTransition t7 = new PetriTransition(pn);
		t7.TransitionName = "T7";
		t7.InputPlaceName.add("r1r2y3");
		
		Condition T7Ct1 = new Condition(t7, "r1r2y3", TransitionCondition.NotNull);

		GuardMapping grdT7 = new GuardMapping();
		grdT7.condition= T7Ct1;
		grdT7.Activations.add(new Activation(t7, "r1r2y3", TransitionOperation.Move, "r1r2r3"));
		grdT7.Activations.add(new Activation(t7, "red", TransitionOperation.SendOverNetwork, "OP3"));
				
		t7.GuardMappingList.add(grdT7);
	
		t7.Delay = 5;
		pn.Transitions.add(t7);
		

		// -------------------------------------------------------------------------------------
		// ----------------------------PN Start-------------------------------------------------
		// -------------------------------------------------------------------------------------

		System.out.println("Controller 1 started \n ------------------------------");
		pn.Delay = 1800;
		// pn.Start();

		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	
	}
}
