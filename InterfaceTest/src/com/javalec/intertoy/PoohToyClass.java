package com.javalec.intertoy;

public class PoohToyClass implements MoveArmLeg {

	public PoohToyClass() {
		// TODO Auto-generated constructor stub
		System.out.println("곰돌이 입니다.");
		canMoveArmLeg();
		System.out.println("==============================");
	}
	
	@Override
	public void canMoveArmLeg() {
		// TODO Auto-generated method stub
		System.out.println("팔다리를 움직일 수 있습니다.");
	}

}
