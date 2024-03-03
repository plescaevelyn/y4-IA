#!/usr/bin/env python3
# -- coding: utf-8 --
# ##
# @brief    The implementation of the RCS project, which targets the task of 
#	    picking and placing an object from and to specific locations using the 
#	    Doosan M1013 robotic platform
# @author   Plesca Evelyn-Iulia (plescaevelyn)   

# Importing needed libraries
import rospy
import os
import threading, time
import sys
sys.dont_write_bytecode = True
sys.path.append('/home/plescaevelyn/catkin_ws/src/y4-IA/RCS/project/scripts')
sys.path.append( os.path.abspath(os.path.join(os.path.dirname(__file__),"../../../../doosan-robot/common/imp")) ) # get import path : DSR_ROBOT.py 

# defining a single robot
ROBOT_ID     = "dsr01"
ROBOT_MODEL  = "m1013"
import DR_init
DR_init.__dsr__id = ROBOT_ID
DR_init.__dsr__model = ROBOT_MODEL
from DSR_ROBOT import *

# Global variables for ROS service proxies and publisher
pub_stop = None
srv_robotiq_2f_open = None
srv_robotiq_2f_move = None

# Define functions for opening and closing the gripper
def gripper_grasp(width):
    global srv_robotiq_2f_move
    
    # close the gripper with a width of 0.1 - 0.8 units
    try:
        # Attempt to call the service
        srv_robotiq_2f_move(width)
    except rospy.ServiceException as e:
        rospy.logerr("Service call failed: %s", e) 
    
def gripper_release():
    global srv_robotiq_2f_open
    
    # open the gripper
    try:
        # Attempt to call the service
        srv_robotiq_2f_open()
    except rospy.ServiceException as e:
        rospy.logerr("Service call failed: %s", e)

def SET_ROBOT(id, model):
    ROBOT_ID = id; ROBOT_MODEL= model   

def pick_and_place(initial_pose, final_pose):
    # Move to the initial pose
    movej(initial_pose, vel=60, acc=30)

    # Close the gripper to pick up the object
    gripper_grasp(0.4)

    # Wait for the gripper to close
    time.sleep(1)

    # Relative motion for picking up the object
    movel(x1, velx, accx, 2, 0, MOVE_REFERENCE_BASE, MOVE_MODE_RELATIVE)

    # Move to the final pose
    movej(final_pose, vel=60, acc=30)

    # Relative motion for placing the object
    movel(x1, velx, accx, 2, 0, MOVE_REFERENCE_BASE, MOVE_MODE_RELATIVE)

    # Open the gripper to place the object
    gripper_release()

    # Wait for the gripper to open
    time.sleep(1)

    # Relative motion after placing the object
    movel(x2, velx, accx, 2, 0, MOVE_REFERENCE_BASE, MOVE_MODE_RELATIVE)

def shutdown():
    print("shutdown time!")
    print("shutdown time!")
    print("shutdown time!")

    pub_stop.publish(stop_mode=1) #STOP_TYPE_QUICK)
    return 0

# convert list to Float64MultiArray
def _ros_listToFloat64MultiArray(list_src):
    _res = []
    for i in list_src:
        item = Float64MultiArray()
        item.data = i
        _res.append(item)
    #print(_res)
    #print(len(_res))
    return _res
 
if __name__ == "__main__":
    # set target robot
    my_robot_id    = "dsr01"
    my_robot_model = "m1013"
    SET_ROBOT(my_robot_id, my_robot_model)

    rospy.init_node('pick_and_place_simple_py')
    rospy.on_shutdown(shutdown)

    # Check if the gripper open service is available
    rospy.wait_for_service('/' + ROBOT_ID + ROBOT_MODEL + '/gripper/robotiq_2f_open', timeout=None)
    # Check if the gripper move service is available
    rospy.wait_for_service('/' + ROBOT_ID + ROBOT_MODEL + '/gripper/g', timeout=None)

    pub_stop = rospy.Publisher('/'+ROBOT_ID+ROBOT_MODEL+'/stop', RobotStop, queue_size=10)

    srv_robotiq_2f_open = rospy.ServiceProxy('/' + ROBOT_ID + ROBOT_MODEL + '/gripper/robotiq_2f_open', Robotiq2FOpen)       
    srv_robotiq_2f_move = rospy.ServiceProxy('/' + ROBOT_ID + ROBOT_MODEL + '/gripper/g', Robotiq2FMove)

    while not rospy.is_shutdown():
    	# position and rotation from coordinates are needed
        print("Enter the initial position (format: x y z a b c): ")
        initial_pose = list(map(float, input().split()))
        print("Enter the final position (format: x y z a b c): ")
        final_pose = list(map(float, input().split()))
    
        # Call the pick_and_place function with the provided positions
        pick_and_place(initial_pose, final_pose)

    print('good bye!')
