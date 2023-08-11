package check;

import constants.Constants;

public class Check {
	//①【Check.java】にてフィールド変数firstNameとlastNameを宣言し、
	//firstName →　自分の名字　lastName →　自分の名前で初期化しなさい。
	//なお、変数のアクセス修飾子は「private」とする。
	private static String firstName = "西尾";
	private static String lastName = "悠";

	//②【Check.java】にてfirstNameとlastNameを引数で受け取って、
	//連結して表示させるメソッド「printName」を作成しなさい。
	//作成した関数のアクセス修飾子は「private」とする。
	private static String printName(String firstName,String lastName) {
		return firstName + lastName;
	}

	//③【Check.java】にてPetクラスとRobotPetクラスをインスタンス化して、下記の完成イメージを出力させなさい。
	public static void main(String[] args) {

		System.out.println("printNameメソッド → " + printName(firstName,lastName));

		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
		RobotPet robotpet = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);

		pet.introduce();
		robotpet.introduce();
	}

}
