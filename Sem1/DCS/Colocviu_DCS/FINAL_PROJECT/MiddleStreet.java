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
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class MiddleStreet {
	public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "MiddleStreet";
        pn.NetworkPort = 1081;

        // -------------------------------------------------------------------
        // -------------------------------Lane1--------------------------------
        // --------------------------------------------------------------------
        
        DataTransfer p_4I = new DataTransfer();
        p_4I.SetName("P_4I");
        p_4I.Value = new TransferOperation("localhost", "1080" , "P_a4");
        pn.PlaceList.add(p_4I);
        
        
        DataCarQueue p2 = new DataCarQueue();
        p2.SetName("P2");
        p2.Value.Size = 3;
        pn.PlaceList.add(p2);
        
        DataCarQueue p3 = new DataCarQueue();
        p3.SetName("P3");
        p3.Value.Size = 3;
        pn.PlaceList.add(p3);
        
        DataCar p5 = new DataCar();
        p5.SetName("P5");
        pn.PlaceList.add(p5);
        
        DataCar p6 = new DataCar();
        p6.SetName("P6");
        pn.PlaceList.add(p6);
        
        DataCar p10 = new DataCar();
        p10.SetName("P10");
        pn.PlaceList.add(p10);
        
        DataCar p_2E = new DataCar();
        p_2E.SetName("P_2E");
        pn.PlaceList.add(p_2E);
        
        // -------------------------------------------------------------------
        // -------------------------------Lane2--------------------------------
        // --------------------------------------------------------------------
        
        DataCarQueue p8 = new DataCarQueue();
        p8.SetName("P8");
        p8.Value.Size = 3;
        pn.PlaceList.add(p8);
        
        DataCar p9 = new DataCar();
        p9.SetName("P9");
        pn.PlaceList.add(p9);
        
        
        DataCar p_4E = new DataCar();
        p_4E.SetName("P_4E");
        pn.PlaceList.add(p_4E);
        
        DataTransfer p_2I = new DataTransfer();
        p_2I.SetName("P_2I");
        p_2I.Value = new TransferOperation("localhost", "1082" , "P_a2");
        pn.PlaceList.add(p_2I);
        
     
        // T1 ------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("P2");

        Condition T1Ct1 = new Condition(t1, "P2", TransitionCondition.HaveCar);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P2", TransitionOperation.PopElementWithoutTarget, "P10"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 0;
        pn.Transitions.add(t1);
        
     // Tt ------------------------------------
        PetriTransition tt = new PetriTransition(pn);
        tt.TransitionName = "Tt";
        tt.InputPlaceName.add("P10");

        Condition TtCt1 = new Condition(tt, "P10", TransitionCondition.NotNull);

        GuardMapping grdTt = new GuardMapping();
        grdTt.condition= TtCt1;
        grdTt.Activations.add(new Activation(tt, "P10", TransitionOperation.SendOverNetwork, "P_4I"));
        tt.GuardMappingList.add(grdTt);

        tt.Delay = 0;
        pn.Transitions.add(tt);
        
     // T2 ------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2m";
        t2.InputPlaceName.add("P3");

        Condition T2Ct1 = new Condition(t2, "P3", TransitionCondition.HaveCarForMe);
        Condition T2Ct2 = new Condition(t2, "P2", TransitionCondition.CanAddCars);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition= T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P3", TransitionOperation.PopElementWithTargetToQueue, "P2"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 0;
        pn.Transitions.add(t2);
        
     // T3 ------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("P_2E");

        Condition T3Ct1 = new Condition(t3, "P_2E", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t3, "P3", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P_2E", TransitionOperation.AddElement, "P3"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 0;
        pn.Transitions.add(t3);
        
     // T4 ------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("P5");

        Condition T4Ct1 = new Condition(t4, "P5", TransitionCondition.NotNull);
        Condition T4Ct2 = new Condition(t4, "P2", TransitionCondition.CanAddCars);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition= T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P5", TransitionOperation.AddElement, "P2"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 0;
        pn.Transitions.add(t4);
        
     // T5 ------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("P3");

        Condition T5Ct1 = new Condition(t5, "P3", TransitionCondition.HaveCar);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P3", TransitionOperation.PopElementWithoutTarget, "P6"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 0;
        pn.Transitions.add(t5);
        
     // T6 ------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("P_4E");

        Condition T6Ct1 = new Condition(t6, "P_4E", TransitionCondition.NotNull);
        Condition T6Ct2 = new Condition(t6, "P8", TransitionCondition.CanAddCars);
        
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition= T6Ct1;
        grdT6.Activations.add(new Activation(t6, "P_4E", TransitionOperation.AddElement, "P8"));
        t6.GuardMappingList.add(grdT6);

        t6.Delay = 0;
        pn.Transitions.add(t6);
        
     // T7 ------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("P8");

        Condition T7Ct1 = new Condition(t7, "P8", TransitionCondition.HaveCar);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition= T7Ct1;
        grdT7.Activations.add(new Activation(t7, "P8", TransitionOperation.PopElementWithoutTarget, "P9"));
        t7.GuardMappingList.add(grdT7);

        t7.Delay = 0;
        pn.Transitions.add(t7);
        
        // T8 ------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("P9");

        Condition T8Ct1 = new Condition(t8, "P9", TransitionCondition.NotNull);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition= T8Ct1;
        grdT8.Activations.add(new Activation(t8, "P9", TransitionOperation.SendOverNetwork, "P_2I"));
        t8.GuardMappingList.add(grdT8);

        t8.Delay = 0;
        pn.Transitions.add(t8);
        
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
