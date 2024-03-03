package FINAL_PROJECT;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Intersection1 {
    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Intersection1";
        pn.NetworkPort = 1080;

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
        
        // -------------------------------------------------------------------
        // -------------------------------Lane2--------------------------------
        // --------------------------------------------------------------------
        
        DataCar p_a2 = new DataCar();
        p_a2.SetName("P_a2");
        pn.PlaceList.add(p_a2);
        
        DataCarQueue p_x2 = new DataCarQueue();
        p_x2.SetName("P_x2");
        p_x2.Value.Size = 3;
        pn.PlaceList.add(p_x2);
        
        // -------------------------------------------------------------------
        // -------------------------------Lane3--------------------------------
        // --------------------------------------------------------------------
        DataCar p_a3 = new DataCar();
        p_a3.SetName("P_a3");
        pn.PlaceList.add(p_a3);
        
        DataCarQueue p_x3 = new DataCarQueue();
        p_x3.SetName("P_x3");
        p_x3.Value.Size = 3;
        pn.PlaceList.add(p_x3);
        
        // -------------------------------------------------------------------
        // -------------------------------Lane4--------------------------------
        // --------------------------------------------------------------------
        
        DataCar p_a4 = new DataCar();
        p_a4.SetName("P_a4");
        pn.PlaceList.add(p_a4);
        
        DataCarQueue p_x4 = new DataCarQueue();
        p_x4.SetName("P_x4");
        p_x4.Value.Size = 3;
        pn.PlaceList.add(p_x4);
        
        // -------------------------------------------------------------------
        // -------------------------------Lane5--------------------------------
        // --------------------------------------------------------------------
        DataCar p_a5 = new DataCar();
        p_a5.SetName("P_a5");
        pn.PlaceList.add(p_a5);
        
        DataCarQueue p_x5 = new DataCarQueue();
        p_x5.SetName("P_x5");
        p_x5.Value.Size = 3;
        pn.PlaceList.add(p_x5);
        
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
        
        DataTransfer p_4E = new DataTransfer();
		p_4E.SetName("P_4E");
		p_4E.Value = new TransferOperation("localhost", "1081" , "P_4E");
		pn.PlaceList.add(p_4E);
        
        // ----------------------------------------------------------------------------
     	// ----------------------------Exit lane 5-------------------------------------
     	// ----------------------------------------------------------------------------
        
        DataCar p_o5e = new DataCar();
        p_o5e.SetName("P_o5e");
        pn.PlaceList.add(p_o5e);
        
        DataCarQueue p_o5 = new DataCarQueue();
        p_o5.SetName("P_o5");
        p_o5.Value.Size = 3;
        pn.PlaceList.add(p_o5);
      
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
        
        DataCarQueue p5 = new DataCarQueue();
        p5.SetName("P5");
        p5.Value.Size = 3;
        pn.PlaceList.add(p5);
        
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
        Condition T4Ct2 = new Condition(t4, "P5", TransitionCondition.CanAddCars);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition= T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P4", TransitionOperation.PopElementWithTargetToQueue, "P5"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 0;
        pn.Transitions.add(t4);
        
     // T5 ------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("P5");

        Condition T5Ct1 = new Condition(t5, "P5", TransitionCondition.HaveCarForMe);
        Condition T5Ct2 = new Condition(t5, "P1", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P5", TransitionOperation.PopElementWithTargetToQueue, "P1"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 0;
        pn.Transitions.add(t5);
        
     // T_i1 ------------------------------------
        PetriTransition t_i1 = new PetriTransition(pn);
        t_i1.TransitionName = "T_i1";
        t_i1.InputPlaceName.add("P1");
        t_i1.InputPlaceName.add("P_x1");

        Condition T_i1Ct1 = new Condition(t_i1, "P_x1", TransitionCondition.HaveCarForMe);
        Condition T_i1Ct2 = new Condition(t_i1, "P1", TransitionCondition.CanAddCars);
        T_i1Ct1.SetNextCondition(LogicConnector.AND, T_i1Ct2);

        GuardMapping grdT_i1 = new GuardMapping();
        grdT_i1.condition= T_i1Ct1;
        grdT_i1.Activations.add(new Activation(t_i1, "P_x1", TransitionOperation.PopElementWithTargetToQueue, "P1"));
        t_i1.GuardMappingList.add(grdT_i1);

        t_i1.Delay = 0;
        pn.Transitions.add(t_i1);
        
     // T_i2 ------------------------------------
        PetriTransition t_i2 = new PetriTransition(pn);
        t_i2.TransitionName = "T_i2";
        t_i2.InputPlaceName.add("P2");
        t_i2.InputPlaceName.add("P_x2");

        Condition T_i2Ct1 = new Condition(t_i2, "P_x2", TransitionCondition.HaveCarForMe);
        Condition T_i2Ct2 = new Condition(t_i2, "P2", TransitionCondition.CanAddCars);
        T_i2Ct1.SetNextCondition(LogicConnector.AND, T_i2Ct2);

        GuardMapping grdT_i2 = new GuardMapping();
        grdT_i2.condition= T_i2Ct1;
        grdT_i2.Activations.add(new Activation(t_i2, "P_x2", TransitionOperation.PopElementWithTargetToQueue, "P2"));
        t_i2.GuardMappingList.add(grdT_i2);

        t_i2.Delay = 0;
        pn.Transitions.add(t_i2);
        
     // T_i3 ------------------------------------
        PetriTransition t_i3 = new PetriTransition(pn);
        t_i3.TransitionName = "T_i3";
        t_i3.InputPlaceName.add("P3");
        t_i3.InputPlaceName.add("P_x3");

        Condition T_i3Ct1 = new Condition(t_i3, "P_x3", TransitionCondition.HaveCarForMe);
        Condition T_i3Ct2 = new Condition(t_i3, "P3", TransitionCondition.CanAddCars);
        T_i3Ct1.SetNextCondition(LogicConnector.AND, T_i3Ct2);

        GuardMapping grdT_i3 = new GuardMapping();
        grdT_i3.condition= T_i3Ct1;
        grdT_i3.Activations.add(new Activation(t_i3, "P_x3", TransitionOperation.PopElementWithTargetToQueue, "P3"));
        t_i3.GuardMappingList.add(grdT_i3);

        t_i3.Delay = 0;
        pn.Transitions.add(t_i3);
        
     // T_i4 ------------------------------------
        PetriTransition t_i4 = new PetriTransition(pn);
        t_i4.TransitionName = "T_i4";
        t_i4.InputPlaceName.add("P4");
        t_i4.InputPlaceName.add("P_x4");

        Condition T_i4Ct1 = new Condition(t_i4, "P_x4", TransitionCondition.HaveCarForMe);
        Condition T_i4Ct2 = new Condition(t_i4, "P4", TransitionCondition.CanAddCars);
        T_i4Ct1.SetNextCondition(LogicConnector.AND, T_i4Ct2);

        GuardMapping grdT_i4 = new GuardMapping();
        grdT_i4.condition= T_i4Ct1;
        grdT_i4.Activations.add(new Activation(t_i4, "P_x4", TransitionOperation.PopElementWithTargetToQueue, "P4"));
        t_i4.GuardMappingList.add(grdT_i4);

        t_i4.Delay = 0;
        pn.Transitions.add(t_i4);
        
     // T_i5 ------------------------------------
        PetriTransition t_i5 = new PetriTransition(pn);
        t_i5.TransitionName = "T_i5";
        t_i5.InputPlaceName.add("P5");
        t_i5.InputPlaceName.add("P_x5");

        Condition T_i5Ct1 = new Condition(t_i5, "P_x5", TransitionCondition.HaveCarForMe);
        Condition T_i5Ct2 = new Condition(t_i5, "P5", TransitionCondition.CanAddCars);
        T_i5Ct1.SetNextCondition(LogicConnector.AND, T_i5Ct2);

        GuardMapping grdT_i5 = new GuardMapping();
        grdT_i5.condition= T_i5Ct1;
        grdT_i5.Activations.add(new Activation(t_i5, "P_x5", TransitionOperation.PopElementWithTargetToQueue, "P5"));
        t_i5.GuardMappingList.add(grdT_i5);

        t_i5.Delay = 0;
        pn.Transitions.add(t_i5);
        
     // T_o1 ------------------------------------
        PetriTransition t_o1 = new PetriTransition(pn);
        t_o1.TransitionName = "T_o1";
        t_o1.InputPlaceName.add("P_o1");
        t_o1.InputPlaceName.add("P1");

        Condition T_o1Ct1 = new Condition(t_o1, "P1", TransitionCondition.HaveCarForMe);
        Condition T_o1Ct2 = new Condition(t_o1, "P_o1", TransitionCondition.CanAddCars);
        T_o1Ct1.SetNextCondition(LogicConnector.AND, T_o1Ct2);

        GuardMapping grdT_o1 = new GuardMapping();
        grdT_o1.condition= T_o1Ct1;
        grdT_o1.Activations.add(new Activation(t_o1, "P1", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
        t_o1.GuardMappingList.add(grdT_o1);

        t_o1.Delay = 0;
        pn.Transitions.add(t_o1);
        
     // T_o2 ------------------------------------
        PetriTransition t_o2 = new PetriTransition(pn);
        t_o2.TransitionName = "T_o2";
        t_o2.InputPlaceName.add("P_o2");
        t_o2.InputPlaceName.add("P2");

        Condition T_o2Ct1 = new Condition(t_o2, "P2", TransitionCondition.HaveCarForMe);
        Condition T_o2Ct2 = new Condition(t_o2, "P_o2", TransitionCondition.CanAddCars);
        T_o2Ct1.SetNextCondition(LogicConnector.AND, T_o2Ct2);

        GuardMapping grdT_o2 = new GuardMapping();
        grdT_o2.condition= T_o2Ct1;
        grdT_o2.Activations.add(new Activation(t_o2, "P2", TransitionOperation.PopElementWithTargetToQueue, "P_o2"));
        t_o2.GuardMappingList.add(grdT_o2);

        t_o2.Delay = 0;
        pn.Transitions.add(t_o2);
        
     // T_o3 ------------------------------------
        PetriTransition t_o3 = new PetriTransition(pn);
        t_o3.TransitionName = "T_o3";
        t_o3.InputPlaceName.add("P_o3");
        t_o3.InputPlaceName.add("P3");

        Condition T_o3Ct1 = new Condition(t_o3, "P3", TransitionCondition.HaveCarForMe);
        Condition T_o3Ct2 = new Condition(t_o3, "P_o3", TransitionCondition.CanAddCars);
        T_o3Ct1.SetNextCondition(LogicConnector.AND, T_o3Ct2);

        GuardMapping grdT_o3 = new GuardMapping();
        grdT_o3.condition= T_o3Ct1;
        grdT_o3.Activations.add(new Activation(t_o3, "P3", TransitionOperation.PopElementWithTargetToQueue, "P_o3"));
        t_o3.GuardMappingList.add(grdT_o3);

        t_o3.Delay = 0;
        pn.Transitions.add(t_o3);
        
     // T_o4 ------------------------------------
        PetriTransition t_o4 = new PetriTransition(pn);
        t_o4.TransitionName = "T_o4";
        t_o4.InputPlaceName.add("P_o4");
        t_o4.InputPlaceName.add("P4");

        Condition T_o4Ct1 = new Condition(t_o4, "P4", TransitionCondition.HaveCarForMe);
        Condition T_o4Ct2 = new Condition(t_o4, "P_o4", TransitionCondition.CanAddCars);
        T_o4Ct1.SetNextCondition(LogicConnector.AND, T_o4Ct2);

        GuardMapping grdT_o4 = new GuardMapping();
        grdT_o4.condition= T_o4Ct1;
        grdT_o4.Activations.add(new Activation(t_o4, "P4", TransitionOperation.PopElementWithTargetToQueue, "P_o4"));
        t_o4.GuardMappingList.add(grdT_o4);

        t_o4.Delay = 0;
        pn.Transitions.add(t_o4);
        
     // T_o5 ------------------------------------
        PetriTransition t_o5 = new PetriTransition(pn);
        t_o5.TransitionName = "T_o5";
        t_o5.InputPlaceName.add("P_o5");
        t_o5.InputPlaceName.add("P5");

        Condition T_o5Ct1 = new Condition(t_o5, "P5", TransitionCondition.HaveCarForMe);
        Condition T_o5Ct2 = new Condition(t_o5, "P_o5", TransitionCondition.CanAddCars);
        T_o5Ct1.SetNextCondition(LogicConnector.AND, T_o5Ct2);

        GuardMapping grdT_o5 = new GuardMapping();
        grdT_o5.condition= T_o5Ct1;
        grdT_o5.Activations.add(new Activation(t_o5, "P5", TransitionOperation.PopElementWithTargetToQueue, "P_o5"));
        t_o5.GuardMappingList.add(grdT_o5);

        t_o5.Delay = 0;
        pn.Transitions.add(t_o5);
        
        //TODO check
     // T_a1 ------------------------------------
        PetriTransition t_a1 = new PetriTransition(pn);
        t_a1.TransitionName = "T_a1";
        t_a1.InputPlaceName.add("P_a1");
        t_a1.InputPlaceName.add("P_x1");

        Condition T_a1Ct1 = new Condition(t_a1, "P_a1", TransitionCondition.NotNull);
        Condition T_a1Ct2 = new Condition(t_a1, "P_x1", TransitionCondition.CanAddCars);
        T_a1Ct1.SetNextCondition(LogicConnector.AND, T_a1Ct2);

        GuardMapping grdT_a1 = new GuardMapping();
        grdT_a1.condition= T_a1Ct1;
        grdT_a1.Activations.add(new Activation(t_a1, "P_a1", TransitionOperation.AddElement, "P_x1"));
        t_a1.GuardMappingList.add(grdT_a1);

        Condition T_a1Ct3 = new Condition(t_a1, "P_a1", TransitionCondition.NotNull);
		Condition T_a1Ct4 = new Condition(t_a1, "P_x1", TransitionCondition.CanNotAddCars);
		T_a1Ct3.SetNextCondition(LogicConnector.AND, T_a1Ct4);

		GuardMapping grdT_a11 = new GuardMapping();
		grdT_a11.condition= T_a1Ct3;
		grdT_a11.Activations.add(new Activation(t1, "P_a1", TransitionOperation.Move, "P_a1"));
		t_a1.GuardMappingList.add(grdT_a11);
        
        t_a1.Delay = 0;
        pn.Transitions.add(t_a1);
        
        
     // T_a2 ------------------------------------
        PetriTransition t_a2 = new PetriTransition(pn);
        t_a2.TransitionName = "T_a2";
        t_a2.InputPlaceName.add("P_a2");
        t_a2.InputPlaceName.add("P_x2");

        Condition T_a2Ct1 = new Condition(t_a2, "P_a2", TransitionCondition.NotNull);
        Condition T_a2Ct2 = new Condition(t_a2, "P_x2", TransitionCondition.CanAddCars);
        T_a2Ct1.SetNextCondition(LogicConnector.AND, T_a2Ct2);

        GuardMapping grdT_a2 = new GuardMapping();
        grdT_a2.condition= T_a2Ct1;
        grdT_a2.Activations.add(new Activation(t_a2, "P_a2", TransitionOperation.AddElement, "P_x2"));
        t_a2.GuardMappingList.add(grdT_a2);

        Condition T_a2Ct3 = new Condition(t_a2, "P_a2", TransitionCondition.NotNull);
		Condition T_a2Ct4 = new Condition(t_a2, "P_x2", TransitionCondition.CanNotAddCars);
		T_a2Ct3.SetNextCondition(LogicConnector.AND, T_a2Ct4);

		GuardMapping grdT_a22 = new GuardMapping();
		grdT_a22.condition= T_a2Ct3;
		grdT_a22.Activations.add(new Activation(t2, "P_a2", TransitionOperation.Move, "P_a2"));
		t_a2.GuardMappingList.add(grdT_a22);
        
        t_a2.Delay = 0;
        pn.Transitions.add(t_a2);

     // T_a3 ------------------------------------
        PetriTransition t_a3 = new PetriTransition(pn);
        t_a3.TransitionName = "T_a3";
        t_a3.InputPlaceName.add("P_a3");
        t_a3.InputPlaceName.add("P_x3");

        Condition T_a3Ct1 = new Condition(t_a3, "P_a3", TransitionCondition.NotNull);
        Condition T_a3Ct2 = new Condition(t_a3, "P_x3", TransitionCondition.CanAddCars);
        T_a3Ct1.SetNextCondition(LogicConnector.AND, T_a3Ct2);

        GuardMapping grdT_a3 = new GuardMapping();
        grdT_a3.condition= T_a3Ct1;
        grdT_a3.Activations.add(new Activation(t_a3, "P_a3", TransitionOperation.AddElement, "P_x3"));
        t_a3.GuardMappingList.add(grdT_a3);

        Condition T_a3Ct3 = new Condition(t_a3, "P_a3", TransitionCondition.NotNull);
		Condition T_a3Ct4 = new Condition(t_a3, "P_x3", TransitionCondition.CanNotAddCars);
		T_a3Ct3.SetNextCondition(LogicConnector.AND, T_a3Ct4);

		GuardMapping grdT_a33 = new GuardMapping();
		grdT_a33.condition= T_a3Ct3;
		grdT_a33.Activations.add(new Activation(t3, "P_a3", TransitionOperation.Move, "P_a3"));
		t_a3.GuardMappingList.add(grdT_a33);
        
        t_a3.Delay = 0;
        pn.Transitions.add(t_a3);
        
     // T_a4 ------------------------------------
        PetriTransition t_a4 = new PetriTransition(pn);
        t_a4.TransitionName = "T_a4";
        t_a4.InputPlaceName.add("P_a4");
        t_a4.InputPlaceName.add("P_x4");

        Condition T_a4Ct1 = new Condition(t_a4, "P_a4", TransitionCondition.NotNull);
        Condition T_a4Ct2 = new Condition(t_a4, "P_x4", TransitionCondition.CanAddCars);
        T_a4Ct1.SetNextCondition(LogicConnector.AND, T_a4Ct2);

        GuardMapping grdT_a4 = new GuardMapping();
        grdT_a4.condition= T_a4Ct1;
        grdT_a4.Activations.add(new Activation(t_a4, "P_a4", TransitionOperation.AddElement, "P_x4"));
        t_a4.GuardMappingList.add(grdT_a4);

        Condition T_a4Ct3 = new Condition(t_a4, "P_a4", TransitionCondition.NotNull);
		Condition T_a4Ct4 = new Condition(t_a4, "P_x4", TransitionCondition.CanNotAddCars);
		T_a4Ct3.SetNextCondition(LogicConnector.AND, T_a4Ct4);

		GuardMapping grdT_a44 = new GuardMapping();
		grdT_a44.condition= T_a4Ct3;
		grdT_a44.Activations.add(new Activation(t4, "P_a4", TransitionOperation.Move, "P_a4"));
		t_a4.GuardMappingList.add(grdT_a44);
        
        t_a4.Delay = 0;
        pn.Transitions.add(t_a4);
        
     // T_a5 ------------------------------------
        PetriTransition t_a5 = new PetriTransition(pn);
        t_a5.TransitionName = "T_a5";
        t_a5.InputPlaceName.add("P_a5");
        t_a5.InputPlaceName.add("P_x5");

        Condition T_a5Ct1 = new Condition(t_a5, "P_a5", TransitionCondition.NotNull);
        Condition T_a5Ct2 = new Condition(t_a5, "P_x5", TransitionCondition.CanAddCars);
        T_a5Ct1.SetNextCondition(LogicConnector.AND, T_a5Ct2);

        GuardMapping grdT_a5 = new GuardMapping();
        grdT_a5.condition= T_a5Ct1;
        grdT_a5.Activations.add(new Activation(t_a5, "P_a5", TransitionOperation.AddElement, "P_x5"));
        t_a5.GuardMappingList.add(grdT_a5);

        Condition T_a5Ct3 = new Condition(t_a5, "P_a5", TransitionCondition.NotNull);
		Condition T_a5Ct4 = new Condition(t_a5, "P_x5", TransitionCondition.CanNotAddCars);
		T_a5Ct3.SetNextCondition(LogicConnector.AND, T_a5Ct4);

		GuardMapping grdT_a55 = new GuardMapping();
		grdT_a55.condition= T_a5Ct3;
		grdT_a55.Activations.add(new Activation(t5, "P_a5", TransitionOperation.Move, "P_a5"));
		t_a5.GuardMappingList.add(grdT_a55);
        
        t_a5.Delay = 0;
        pn.Transitions.add(t_a5);
        
        
     // T_o1e ------------------------------------
        PetriTransition t_o1e = new PetriTransition(pn);
        t_o1e.TransitionName = "T_o1e";
        t_o1e.InputPlaceName.add("P_o1");
        
        Condition T_o1eCt1 = new Condition(t_o1e, "P_o1", TransitionCondition.HaveCar);

        GuardMapping grdT_o1e = new GuardMapping();
        grdT_o1e.condition = T_o1eCt1;
        grdT_o1e.Activations.add(new Activation(t_o1e, "P_o1", TransitionOperation.PopElementWithoutTarget, "P_o1e"));
        t_o1e.GuardMappingList.add(grdT_o1e);

        t_o1e.Delay = 0;
        pn.Transitions.add(t_o1e);
        
     // T_o2e ------------------------------------
        PetriTransition t_o2e = new PetriTransition(pn);
        t_o2e.TransitionName = "T_o2e";
        t_o2e.InputPlaceName.add("P_o2");
        
        Condition T_o2eCt1 = new Condition(t_o2e, "P_o2", TransitionCondition.HaveCar);

        GuardMapping grdT_o2e = new GuardMapping();
        grdT_o2e.condition = T_o2eCt1;
        grdT_o2e.Activations.add(new Activation(t_o2e, "P_o1", TransitionOperation.PopElementWithoutTarget, "P_o2e"));
        t_o2e.GuardMappingList.add(grdT_o2e);

        t_o2e.Delay = 0;
        pn.Transitions.add(t_o2e);
        
     // T_o3e ------------------------------------
        PetriTransition t_o3e = new PetriTransition(pn);
        t_o3e.TransitionName = "T_o3e";
        t_o3e.InputPlaceName.add("P_o3");
        
        Condition T_o3eCt1 = new Condition(t_o3e, "P_o3", TransitionCondition.HaveCar);

        GuardMapping grdT_o3e = new GuardMapping();
        grdT_o3e.condition= T_o3eCt1;
        grdT_o3e.Activations.add(new Activation(t_o3e, "P_o3", TransitionOperation.PopElementWithoutTarget, "P_o3e"));
        t_o3e.GuardMappingList.add(grdT_o3e);

        t_o3e.Delay = 0;
        pn.Transitions.add(t_o3e);
        
     // T_o4e ------------------------------------
        PetriTransition t_o4e = new PetriTransition(pn);
        t_o4e.TransitionName = "T_o4e";
        t_o4e.InputPlaceName.add("P_o4");
        
        Condition T_o4eCt1 = new Condition(t_o4e, "P_o4", TransitionCondition.HaveCar);

        GuardMapping grdT_o4e = new GuardMapping();
        grdT_o4e.condition= T_o4eCt1;
        grdT_o4e.Activations.add(new Activation(t_o4e, "P_o4", TransitionOperation.PopElementWithoutTarget, "P_o4e"));
        t_o4e.GuardMappingList.add(grdT_o4e);

        t_o4e.Delay = 0;
        pn.Transitions.add(t_o4e);
        
     // T_o5e ------------------------------------
        PetriTransition t_o5e = new PetriTransition(pn);
        t_o5e.TransitionName = "T_o5e";
        t_o5e.InputPlaceName.add("P_o5");
        
        Condition T_o5eCt1 = new Condition(t_o5e, "P_o5", TransitionCondition.HaveCar);

        GuardMapping grdT_o5e = new GuardMapping();
        grdT_o5e.condition= T_o5eCt1;
        grdT_o5e.Activations.add(new Activation(t_o5e, "P_o5", TransitionOperation.PopElementWithoutTarget, "P_o5e"));
        t_o5e.GuardMappingList.add(grdT_o5e);

        t_o5e.Delay = 0;
        pn.Transitions.add(t_o5e);

     // T_4E ------------------------------------
        PetriTransition t_4E = new PetriTransition(pn);
        t_4E.TransitionName = "T_4E";
        t_4E.InputPlaceName.add("P_o4e");
        
        Condition T_4ECt1 = new Condition(t_4E, "P_o4e", TransitionCondition.NotNull);

        GuardMapping grdT_4E = new GuardMapping();
        grdT_4E.condition= T_4ECt1;
        grdT_4E.Activations.add(new Activation(t_4E, "P_o4e", TransitionOperation.SendOverNetwork, "P_4E"));
        t_4E.GuardMappingList.add(grdT_4E);

        t_4E.Delay = 0;
        pn.Transitions.add(t_4E);
        
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