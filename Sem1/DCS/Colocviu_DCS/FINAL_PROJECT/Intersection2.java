package FINAL_PROJECT;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataTransfer;
import DataObjects.DataString;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Intersection2 {
	public static void main(String[] args) {

	    PetriNet pn = new PetriNet();
	    pn.PetriNetName = "Intersection2";
	    pn.NetworkPort = 1082;
	    
	    DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);
        
        DataString full = new DataString();
		full.Printable = false;
		full.SetName("full");
		full.SetValue("full");
		pn.ConstantPlaceList.add(full);
	
	    // -------------------------------------------------------------------
	    // -------------------------------Lane1--------------------------------
	    // --------------------------------------------------------------------
	    
	    DataCar p_a1 = new DataCar();
	    p_a1.SetName("P_a1");
	    pn.PlaceList.add(p_a1);
	    
	    DataCarQueue p_x1 = new DataCarQueue();
	    p_x1.SetName("P_x1");
	    p_x1.Value.Size = 3;
	    pn.PlaceList.add(p_x1);

        DataString P_TL1 = new DataString();
        P_TL1.SetName("P_TL1");
        pn.PlaceList.add(P_TL1);

        DataCar P_b1 = new DataCar();
        P_b1.SetName("P_b1");
        pn.PlaceList.add(P_b1);

        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost", "1083", "in1");
        pn.PlaceList.add(OP1);

	    
	    // -------------------------------------------------------------------
	    // -------------------------------Lane2--------------------------------
	    // --------------------------------------------------------------------
        DataCar P_a2 = new DataCar();
        P_a2.SetName("P_a2");
        pn.PlaceList.add(P_a2);

        DataCarQueue P_x2 = new DataCarQueue(); ;
        P_x2.Value.Size = 3;
        P_x2.SetName("P_x2");
        pn.PlaceList.add(P_x2);

        DataString P_TL2 = new DataString();
        P_TL2.SetName("P_TL2");
        pn.PlaceList.add(P_TL2);

        DataCar P_b2 = new DataCar();
        P_b2.SetName("P_b2");
        pn.PlaceList.add(P_b2);

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost", "1083", "in2");
        pn.PlaceList.add(OP2);
	    
	    // -------------------------------------------------------------------
	    // -------------------------------Lane3--------------------------------
	    // --------------------------------------------------------------------
        DataCar P_a3 = new DataCar();
        P_a3.SetName("P_a3");
        pn.PlaceList.add(P_a3);

        DataCarQueue P_x3 = new DataCarQueue();
        P_x3.Value.Size = 3;
        P_x3.SetName("P_x3");
        pn.PlaceList.add(P_x3);

        DataString P_TL3 = new DataString();
        P_TL3.SetName("P_TL3");
        pn.PlaceList.add(P_TL3);

        DataCar P_b3 = new DataCar();
        P_b3.SetName("P_b3");
        pn.PlaceList.add(P_b3);

        DataTransfer OP3 = new DataTransfer();
        OP3.SetName("OP3");
        OP3.Value = new TransferOperation("localhost", "1083", "in3");
        pn.PlaceList.add(OP3);
	    
	    // ----------------------------------------------------------------------------
	 	// ----------------------------Exit lane 1-------------------------------------
	 	// ----------------------------------------------------------------------------
	    DataCar p_o1e = new DataCar();
	    p_o1e.SetName("P_o1e");
	    pn.PlaceList.add(p_o1e);
	    
	    DataCarQueue p_o1 = new DataCarQueue();
	    p_o1.SetName("P_o1");
	    p_o1.Value.Size = 3;
	    pn.PlaceList.add(p_o1);
	    
	    // ----------------------------------------------------------------------------
	 	// ----------------------------Exit lane 2-------------------------------------
	 	// ----------------------------------------------------------------------------
	    
	    DataCar p_o2e = new DataCar();
	    p_o2e.SetName("P_o2e");
	    pn.PlaceList.add(p_o2e);
	
	    DataCarQueue p_o2 = new DataCarQueue();
	    p_o2.SetName("P_o2");
	    p_o2.Value.Size = 3;
	    pn.PlaceList.add(p_o2);

	    DataTransfer p_2E = new DataTransfer();
	    p_2E.SetName("P_2E");
	    p_2E.Value = new TransferOperation("localhost", "1081", "P_2E");
	    pn.PlaceList.add(p_2E);
	    
	    // ----------------------------------------------------------------------------
	 	// ----------------------------Exit lane 3-------------------------------------
	 	// ----------------------------------------------------------------------------
	    
	    DataCar p_o3e = new DataCar();
	    p_o3e.SetName("P_o3e");
	    pn.PlaceList.add(p_o3e);
	    
	    DataCarQueue p_o3 = new DataCarQueue();
	    p_o3.SetName("P_o3");
	    p_o3.Value.Size = 3;
	    pn.PlaceList.add(p_o3);
	    
	    // ----------------------------------------------------------------------------
	 	// ----------------------------Exit lane 4-------------------------------------
	 	// ----------------------------------------------------------------------------
	    
	    DataCar p_o4e = new DataCar();
	    p_o4e.SetName("P_o4e");
	    pn.PlaceList.add(p_o4e);
	    
	    DataCarQueue p_o4 = new DataCarQueue();
	    p_o4.SetName("P_o4");
	    p_o4.Value.Size = 3;
	    pn.PlaceList.add(p_o4);
	  
	 	// -------------------------------------------------------------------------------------------
	 	// --------------------------------Intersection-----------------------------------------------
	 	// -------------------------------------------------------------------------------------------
	    
	    DataCarQueue p1 = new DataCarQueue();
	    p1.SetName("P1");
	    p1.Value.Size = 3;
	    pn.PlaceList.add(p1);
	    
	    DataCarQueue p2 = new DataCarQueue();
	    p2.SetName("P2");
	    p2.Value.Size = 3;
	    pn.PlaceList.add(p2);
	    
	    DataCarQueue p3 = new DataCarQueue();
	    p3.SetName("P3");
	    p3.Value.Size = 3;
	    pn.PlaceList.add(p3);
	
	    DataCarQueue p4 = new DataCarQueue();
	    p4.SetName("P4");
	    p4.Value.Size = 3;
	    pn.PlaceList.add(p4);

	    // T1 ------------------------------------
	    PetriTransition t1 = new PetriTransition(pn);
	    t1.TransitionName = "T1";
	    t1.InputPlaceName.add("P1");
	
	    Condition T1Ct1 = new Condition(t1, "P1", TransitionCondition.HaveCarForMe);
	    Condition T1Ct2 = new Condition(t1, "P2", TransitionCondition.CanAddCars);
	    T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);
	
	    GuardMapping grdT1 = new GuardMapping();
	    grdT1.condition= T1Ct1;
	    grdT1.Activations.add(new Activation(t1, "P1", TransitionOperation.PopElementWithTargetToQueue, "P2"));
	    t1.GuardMappingList.add(grdT1);
	
	    t1.Delay = 0;
	    pn.Transitions.add(t1);
	    
	 // T2 ------------------------------------
	    PetriTransition t2 = new PetriTransition(pn);
	    t2.TransitionName = "T2";
	    t2.InputPlaceName.add("P2");
	
	    Condition T2Ct1 = new Condition(t2, "P2", TransitionCondition.HaveCarForMe);
	    Condition T2Ct2 = new Condition(t2, "P3", TransitionCondition.CanAddCars);
	    T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);
	
	    GuardMapping grdT2 = new GuardMapping();
	    grdT2.condition= T2Ct1;
	    grdT2.Activations.add(new Activation(t2, "P2", TransitionOperation.PopElementWithTargetToQueue, "P3"));
	    t2.GuardMappingList.add(grdT2);
	
	    t2.Delay = 0;
	    pn.Transitions.add(t2);
	    
	 // T3 ------------------------------------
	    PetriTransition t3 = new PetriTransition(pn);
	    t3.TransitionName = "T3";
	    t3.InputPlaceName.add("P3");
	
	    Condition T3Ct1 = new Condition(t3, "P3", TransitionCondition.HaveCarForMe);
	    Condition T3Ct2 = new Condition(t3, "P4", TransitionCondition.CanAddCars);
	    T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);
	
	    GuardMapping grdT3 = new GuardMapping();
	    grdT3.condition= T3Ct1;
	    grdT3.Activations.add(new Activation(t3, "P3", TransitionOperation.PopElementWithTargetToQueue, "P4"));
	    t3.GuardMappingList.add(grdT3);
	
	    t3.Delay = 0;
	    pn.Transitions.add(t3);
	    
	 // T4 ------------------------------------
	    PetriTransition t4 = new PetriTransition(pn);
	    t4.TransitionName = "T4";
	    t4.InputPlaceName.add("P4");
	
	    Condition T4Ct1 = new Condition(t4, "P4", TransitionCondition.HaveCarForMe);
	    Condition T4Ct2 = new Condition(t4, "P1", TransitionCondition.CanAddCars);
	    T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);
	
	    GuardMapping grdT4 = new GuardMapping();
	    grdT4.condition= T4Ct1;
	    grdT4.Activations.add(new Activation(t4, "P4", TransitionOperation.PopElementWithTargetToQueue, "P1"));
	    t4.GuardMappingList.add(grdT4);
	
	    t4.Delay = 0;
	    pn.Transitions.add(t4);
	   	    
	 // T_i1 ------------------------------------
	    PetriTransition t_i1 = new PetriTransition(pn);
        t_i1.TransitionName = "T_i1";
        t_i1.InputPlaceName.add("P_b1");
        t_i1.InputPlaceName.add("P1");

        Condition ti1_ct1 = new Condition(t_i1, "P_b1", TransitionCondition.NotNull);
        Condition ti1_ct2 = new Condition(t_i1, "P1", TransitionCondition.CanAddCars);
        ti1_ct1.SetNextCondition(LogicConnector.AND, ti1_ct2);

        GuardMapping grdti1 = new GuardMapping();
        grdti1.condition = ti1_ct1;
        grdti1.Activations.add(new Activation(t_i1, "P_b1", TransitionOperation.AddElement, "P1"));
        t_i1.GuardMappingList.add(grdti1);

        t_i1.Delay = 0;
        pn.Transitions.add(t_i1);
	    
	 // T_i2 ------------------------------------
        PetriTransition t_i2 = new PetriTransition(pn);
        t_i2.TransitionName = "T_i2";
        t_i2.InputPlaceName.add("P_b2");
        t_i2.InputPlaceName.add("P2");

        Condition ti2_ct1 = new Condition(t_i2, "P_b2", TransitionCondition.NotNull);
        Condition ti2_ct2 = new Condition(t_i2, "P2", TransitionCondition.CanAddCars);
        ti2_ct1.SetNextCondition(LogicConnector.AND, ti2_ct2);

        GuardMapping grdti2 = new GuardMapping();
        grdti2.condition = ti2_ct1;
        grdti2.Activations.add(new Activation(t_i2, "P_b2", TransitionOperation.AddElement, "P2"));
        t_i2.GuardMappingList.add(grdti2);

        t_i2.Delay = 0;
        pn.Transitions.add(t_i2);
	    
	 // T_i3 ------------------------------------
        PetriTransition t_i3 = new PetriTransition(pn);
        t_i3.TransitionName = "T_i3";
        t_i3.InputPlaceName.add("P_b3");
        t_i3.InputPlaceName.add("P3");

        Condition ti3_ct1 = new Condition(t_i3, "P_b3", TransitionCondition.NotNull);
        Condition ti3_ct2 = new Condition(t_i3, "P3", TransitionCondition.CanAddCars);
        ti3_ct1.SetNextCondition(LogicConnector.AND, ti3_ct2);

        GuardMapping grdti3 = new GuardMapping();
        grdti3.condition = ti3_ct1;
        grdti3.Activations.add(new Activation(t_i3, "P_b3", TransitionOperation.AddElement, "P3"));
        t_i3.GuardMappingList.add(grdti3);

        t_i3.Delay = 0;
        pn.Transitions.add(t_i3); 
	    
        // T_g1 -----------------------------------
        PetriTransition t_g1 = new PetriTransition(pn);
        t_g1.TransitionName = "T_g1";
        t_g1.InputPlaceName.add("P1");
        t_g1.InputPlaceName.add("P_o1");

        Condition tg1_ct1 = new Condition(t_g1, "P2", TransitionCondition.HaveCarForMe);
        Condition tg1_ct2 = new Condition(t_g1, "P_o1", TransitionCondition.CanAddCars);
        tg1_ct1.SetNextCondition(LogicConnector.AND, tg1_ct2);

        GuardMapping grdtg1 = new GuardMapping();
        grdtg1.condition = tg1_ct1;
        grdtg1.Activations.add(new Activation(t_g1, "P1", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
        t_g1.GuardMappingList.add(grdtg1);

        t_g1.Delay = 0;
        pn.Transitions.add(t_g1);
	    
        // T_g2 -----------------------------------
        PetriTransition t_g2 = new PetriTransition(pn);
        t_g2.TransitionName = "T_g2";
        t_g2.InputPlaceName.add("P2");
        t_g2.InputPlaceName.add("P_o2");

        Condition tg2_ct1 = new Condition(t_g2, "P2", TransitionCondition.HaveCarForMe);
        Condition tg2_ct2 = new Condition(t_g2, "P_o2", TransitionCondition.CanAddCars);
        tg2_ct1.SetNextCondition(LogicConnector.AND, tg2_ct2);

        GuardMapping grdtg2 = new GuardMapping();
        grdtg2.condition = tg2_ct1;
        grdtg2.Activations.add(new Activation(t_g2, "P2", TransitionOperation.PopElementWithTargetToQueue, "P_o2"));
        t_g2.GuardMappingList.add(grdtg2);

        t_g2.Delay = 0;
        pn.Transitions.add(t_g2);

    	// T_g3 -----------------------------------
        PetriTransition t_g3 = new PetriTransition(pn);
        t_g3.TransitionName = "T_g3";
        t_g3.InputPlaceName.add("P3");
        t_g3.InputPlaceName.add("P_o3");

        Condition tg3_ct1 = new Condition(t_g3, "P3", TransitionCondition.HaveCarForMe);
        Condition tg3_ct2 = new Condition(t_g3, "P_o3", TransitionCondition.CanAddCars);
        tg3_ct1.SetNextCondition(LogicConnector.AND, tg3_ct2);

        GuardMapping grdtg3 = new GuardMapping();
        grdtg3.condition = tg3_ct1;
        grdtg3.Activations.add(new Activation(t_g3, "P3", TransitionOperation.PopElementWithTargetToQueue, "P_o3"));
        t_g3.GuardMappingList.add(grdtg3);

        t_g3.Delay = 0;
        pn.Transitions.add(t_g3);
        
        // T_g4 -----------------------------------
        
        PetriTransition t_g4 = new PetriTransition(pn);
        t_g4.TransitionName = "T_g4";
        t_g4.InputPlaceName.add("P4");
        t_g4.InputPlaceName.add("P_o4");

        Condition tg4_ct1 = new Condition(t_g4, "P4", TransitionCondition.HaveCarForMe);
        Condition tg4_ct2 = new Condition(t_g4, "P_o4", TransitionCondition.CanAddCars);
        tg4_ct1.SetNextCondition(LogicConnector.AND, tg4_ct2);

        GuardMapping grdtg4 = new GuardMapping();
        grdtg4.condition = tg4_ct1;
        grdtg4.Activations.add(new Activation(t_g4, "P4", TransitionOperation.PopElementWithTargetToQueue, "P_o4"));
        t_g4.GuardMappingList.add(grdtg4);

        t_g4.Delay = 0;
        pn.Transitions.add(t_g4);
	    
	    //TODO check
        // T_a1 ------------------------------------
        PetriTransition t_a1 = new PetriTransition(pn);
        t_a1.TransitionName = "T_a1";
        t_a1.InputPlaceName.add("P_a1");
        t_a1.InputPlaceName.add("P_x1");

        Condition ta1_ct1 = new Condition(t_a1, "P_a1", TransitionCondition.NotNull);
        Condition ta1_ct2 = new Condition(t_a1, "P_x1", TransitionCondition.CanAddCars);
        ta1_ct1.SetNextCondition(LogicConnector.AND, ta1_ct2);

        GuardMapping grdta1 = new GuardMapping();
        grdta1.condition = ta1_ct1;

        grdta1.Activations.add(new Activation(t_a1, "P_a1", TransitionOperation.AddElement, "P_x1"));

        t_a1.GuardMappingList.add(grdta1);

        Condition ta1_ct3 = new Condition(t_a1, "P_a1", TransitionCondition.NotNull);
        Condition ta1_ct4 = new Condition(t_a1, "P_x1", TransitionCondition.CanNotAddCars);
        ta1_ct3.SetNextCondition(LogicConnector.AND, ta1_ct4);

        GuardMapping grdta1_2 = new GuardMapping();
        grdta1_2.condition= ta1_ct3;

        grdta1_2.Activations.add(new Activation(t_a1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grdta1_2.Activations.add(new Activation(t_a1, "P_a1", TransitionOperation.Move,"P_a1"));
        t_a1.GuardMappingList.add(grdta1_2);
        t_a1.Delay = 0;
        pn.Transitions.add(t_a1);
	    
	    
	 // T_a2 ------------------------------------
        PetriTransition t_a2 = new PetriTransition(pn);
        t_a2.TransitionName = "T_a2";
        t_a2.InputPlaceName.add("P_a2");
        t_a2.InputPlaceName.add("P_x2");

        Condition ta2_ct1 = new Condition(t_a2, "P_a2", TransitionCondition.NotNull);
        Condition ta2_ct2 = new Condition(t_a2, "P_x2", TransitionCondition.CanAddCars);
        ta2_ct1.SetNextCondition(LogicConnector.AND, ta2_ct2);

        GuardMapping grdta2 = new GuardMapping();
        grdta2.condition = ta2_ct1;

        grdta2.Activations.add(new Activation(t_a2, "P_a2", TransitionOperation.AddElement, "P_x2"));

        t_a2.GuardMappingList.add(grdta2);

        Condition ta2_ct3 = new Condition(t_a2, "P_a2", TransitionCondition.NotNull);
        Condition ta2_ct4 = new Condition(t_a2, "P_x2", TransitionCondition.CanNotAddCars);
        ta2_ct3.SetNextCondition(LogicConnector.AND, ta2_ct4);

        GuardMapping grdta2_2 = new GuardMapping();
        grdta2_2.condition= ta2_ct3;

        grdta2_2.Activations.add(new Activation(t_a2, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdta2_2.Activations.add(new Activation(t_a2, "P_a2", TransitionOperation.Move,"P_a2"));
        t_a2.GuardMappingList.add(grdta2_2);
        t_a2.Delay = 0;
        pn.Transitions.add(t_a2);
	
	 // T_a3 ------------------------------------
        PetriTransition t_a3 = new PetriTransition(pn);
        t_a3.TransitionName = "T_a3";
        t_a3.InputPlaceName.add("P_a3");
        t_a3.InputPlaceName.add("P_x3");

        Condition ta3_ct1 = new Condition(t_a3, "P_a3", TransitionCondition.NotNull);
        Condition ta3_ct2 = new Condition(t_a3, "P_x3", TransitionCondition.CanAddCars);
        ta3_ct1.SetNextCondition(LogicConnector.AND, ta3_ct2);

        GuardMapping grdta3 = new GuardMapping();
        grdta3.condition = ta3_ct1;

        grdta3.Activations.add(new Activation(t_a3, "P_a3", TransitionOperation.AddElement, "P_x3"));

        t_a3.GuardMappingList.add(grdta3);

        Condition ta3_ct3 = new Condition(t_a3, "P_a3", TransitionCondition.NotNull);
        Condition ta3_ct4 = new Condition(t_a3, "P_x3", TransitionCondition.CanNotAddCars);
        ta3_ct3.SetNextCondition(LogicConnector.AND, ta3_ct4);

        GuardMapping grdta3_2 = new GuardMapping();
        grdta3_2.condition= ta3_ct3;

        grdta3_2.Activations.add(new Activation(t_a3, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdta3_2.Activations.add(new Activation(t_a3, "P_a3", TransitionOperation.Move,"P_a3"));
        t_a3.GuardMappingList.add(grdta3_2);
        t_a3.Delay = 0;
        pn.Transitions.add(t_a3);
	    
	 // T_g1e ------------------------------------
	    PetriTransition t_g1e = new PetriTransition(pn);
	    t_g1e.TransitionName = "T_g1e";
	    t_g1e.InputPlaceName.add("P_o1");
	    
	    Condition T_g1eCt1 = new Condition(t_g1e, "P_o1", TransitionCondition.HaveCar);
	
	    GuardMapping grdT_g1e = new GuardMapping();
	    grdT_g1e.condition = T_g1eCt1;
	    grdT_g1e.Activations.add(new Activation(t_g1e, "P_o1", TransitionOperation.PopElementWithoutTarget, "P_o1e"));
	    t_g1e.GuardMappingList.add(grdT_g1e);
	
	    t_g1e.Delay = 0;
	    pn.Transitions.add(t_g1e);
	    
	 // T_g2e ------------------------------------
	    PetriTransition t_g2e = new PetriTransition(pn);
	    t_g2e.TransitionName = "T_g2e";
	    t_g2e.InputPlaceName.add("P_o2");
	    
	    Condition T_g2eCt1 = new Condition(t_g2e, "P_o2", TransitionCondition.HaveCar);
	
	    GuardMapping grdT_g2e = new GuardMapping();
	    grdT_g2e.condition = T_g2eCt1;
	    grdT_g2e.Activations.add(new Activation(t_g2e, "P_o2", TransitionOperation.PopElementWithoutTarget, "P_o2e"));
	    t_g2e.GuardMappingList.add(grdT_g2e);
	
	    t_g2e.Delay = 0;
	    pn.Transitions.add(t_g2e);
	    
	 // T_g3e ------------------------------------
	    PetriTransition t_g3e = new PetriTransition(pn);
	    t_g3e.TransitionName = "T_g3e";
	    t_g3e.InputPlaceName.add("P_o3");
	    
	    Condition T_g3eCt1 = new Condition(t_g3e, "P_o3", TransitionCondition.HaveCar);
	
	    GuardMapping grdT_g3e = new GuardMapping();
	    grdT_g3e.condition = T_g3eCt1;
	    grdT_g3e.Activations.add(new Activation(t_g3e, "P_o3", TransitionOperation.PopElementWithoutTarget, "P_o3e"));
	    t_g3e.GuardMappingList.add(grdT_g3e);
	
	    t_g3e.Delay = 0;
	    pn.Transitions.add(t_g3e);
	    
	 // T_g4e ------------------------------------
	    PetriTransition t_g4e = new PetriTransition(pn);
	    t_g4e.TransitionName = "T_g4e";
	    t_g4e.InputPlaceName.add("P_o4");
	    
	    Condition T_g4eCt1 = new Condition(t_g4e, "P_o4", TransitionCondition.HaveCar);
	
	    GuardMapping grdT_g4e = new GuardMapping();
	    grdT_g4e.condition = T_g4eCt1;
	    grdT_g4e.Activations.add(new Activation(t_g4e, "P_o4", TransitionOperation.PopElementWithoutTarget, "P_o4e"));
	    t_g4e.GuardMappingList.add(grdT_g4e);
	
	    t_g4e.Delay = 0;
	    pn.Transitions.add(t_g4e);
    
	 // T_2E ------------------------------------
	    PetriTransition t_2E = new PetriTransition(pn);
	    t_2E.TransitionName = "T_o2e";
	    t_2E.InputPlaceName.add("P_o2e");
	    
	    Condition T_2ECt1 = new Condition(t_2E, "P_o2e", TransitionCondition.NotNull);
	
	    GuardMapping grdT_2E = new GuardMapping();
	    grdT_2E.condition= T_2ECt1;
	    grdT_2E.Activations.add(new Activation(t_2E, "P_o2e", TransitionOperation.SendOverNetwork, "P_2E"));
	    t_2E.GuardMappingList.add(grdT_2E);
	
	    t_2E.Delay = 0;
	    pn.Transitions.add(t_2E);
	    
	    // T5 ------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("P_a1");

        Condition T5Ct1 = new Condition(t5, "P_a1", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P_a1", TransitionOperation.AddElement, "P_o2e"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 0;
        pn.Transitions.add(t5);
        
        // Tx1 ------------------------------------

        PetriTransition t_x1 = new PetriTransition(pn);
        t_x1.TransitionName = "T_X1";
        t_x1.InputPlaceName.add("P_x1");
        t_x1.InputPlaceName.add("P_TL1");

        Condition tx1_ct1 = new Condition(t_x1, "P_TL1", TransitionCondition.Equal, "green");
        Condition tx1_ct2 = new Condition(t_x1, "P_x1", TransitionCondition.HaveCar);
        tx1_ct1.SetNextCondition(LogicConnector.AND, tx1_ct2);

        GuardMapping grdtx1 = new GuardMapping();
        grdtx1.condition = tx1_ct1;
        grdtx1.Activations.add(new Activation(t_x1, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
        grdtx1.Activations.add(new Activation(t_x1, "P_TL1", TransitionOperation.Move, "P_TL1"));

        t_x1.GuardMappingList.add(grdtx1);

        t_x1.Delay = 3;
        pn.Transitions.add(t_x1);
        
        // Tx2 ------------------------------------

        PetriTransition t_x2 = new PetriTransition(pn);
        t_x2.TransitionName = "T_X2";
        t_x2.InputPlaceName.add("P_x2");
        t_x2.InputPlaceName.add("P_TL2");

        Condition tx2_ct1 = new Condition(t_x2, "P_TL2", TransitionCondition.Equal, "green");
        Condition tx2_ct2 = new Condition(t_x2, "P_x2", TransitionCondition.HaveCar);
        tx2_ct1.SetNextCondition(LogicConnector.AND, tx2_ct2);

        GuardMapping grdtx2 = new GuardMapping();
        grdtx2.condition = tx2_ct1;
        grdtx2.Activations.add(new Activation(t_x2, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_b2"));
        grdtx2.Activations.add(new Activation(t_x2, "P_TL2", TransitionOperation.Move, "P_TL2"));

        t_x2.GuardMappingList.add(grdtx2);

        t_x2.Delay = 3;
        pn.Transitions.add(t_x2);
	    
        // Tx3 ------------------------------------

        PetriTransition t_x3 = new PetriTransition(pn);
        t_x3.TransitionName = "T_X3";
        t_x3.InputPlaceName.add("P_x3");
        t_x3.InputPlaceName.add("P_TL3");

        Condition tx3_ct1 = new Condition(t_x3, "P_TL3", TransitionCondition.Equal, "green");
        Condition tx3_ct2 = new Condition(t_x3, "P_x3", TransitionCondition.HaveCar);
        tx3_ct1.SetNextCondition(LogicConnector.AND, tx3_ct2);

        GuardMapping grdtx3 = new GuardMapping();
        grdtx3.condition = tx3_ct1;
        grdtx3.Activations.add(new Activation(t_x3, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b3"));
        grdtx3.Activations.add(new Activation(t_x3, "P_TL3", TransitionOperation.Move, "P_TL3"));

        t_x3.GuardMappingList.add(grdtx3);

        t_x3.Delay = 3;
        pn.Transitions.add(t_x3);
	    
	    // -------------------------------------------------------------------------------------
	 	// ----------------------------PNStart-------------------------------------------------
	 	// -------------------------------------------------------------------------------------
	
		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 2000;
		// pn.Start();
	
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}
}
