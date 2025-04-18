import java.util.Scanner;
public class Welcome {
	static final int NUM_BOOK = 5;
	static final int NUM_ITEM = 7;
	static CartItem[]mCartItem = new CartItem[NUM_BOOK];
	static int mCartCount = 0;
	

	public static void main(String[] args) {
		String[][]mBook =new String[NUM_BOOK][NUM_ITEM];
		Scanner input=new Scanner(System.in);
		
		System.out.print("당신의 이름을 입력하세요:");
		String userName =input.next();
		System.out.print("당신의 연락처를 입력하세요:");
	    int userMobile =input.nextInt();   //int로 변경 nextInt로 수정
		
		String greeting ="Welcome to Shopping mall";
		String tagline ="welcome to BooK Market";
		
		boolean quit=false;
		while(!quit) {
		
		System.out.println("**************************************");
		System.out.println("\t"+greeting);
		System.out.println("\t"+tagline);
		System.out.println("**************************************");

		//System.out.println("1. 고객정보 확인하기 \t4. 바구니에 항목 추가하기");
		//System.out.println("2. 장바구니상품 목록 보기 \t5. 장바구니의항목 수량 줄이기");
		//System.out.println("3.장바구니 비우기 \t6. 장바구니의 항목 삭제하기");
		//System.out.println("7.영수증 표시하기 \t8. 종료");
		//System.out.println("**************************************");
		
		menuIntroduction();

		System.out.print("메뉴 번호를 선택해주세요");
		int n =input.nextInt();
		System.out.println(n+"번을 선택했습니다");		
		if(n < 1 || n> 8) {
			System.out.println("1부터 8까지의 숫자를 입력하세요:");
		}
		else {
			switch(n) {
			case 1:
				//System.out.println("현재 고객 정보 :");
				//System.out.println("이름"+userName+"연락처"+userMobile);
				menuGuestInfo(userName,userMobile);
				break;
			case 2:
				//System.out.println("장바구니 상품 목록 보기 :");
				menuCartItemList();
				break;
			case 3:
				//System.out.println("장바구니 비우기");
				menuCartClear();
				break;
			case 4:
				//System.out.println("장바구에 항목 추가하기:");
				menuCartAddItem(mBook);
				break;
			case 5:
				//System.out.println("5.장바구니의 항목 수량 줄이기");
				menuCartRemoveItemCount();
				break;
			case 6:
				//System.out.println("6.장바구니의 항목 삭제하기");
				menuCartRemoveItem();
				break;
			case 7:
				//System.out.println("7.영수증 표시하기");
				menuCartBill();
				break;
			case 8:
				//System.out.println("8.종료");
				menuExit();
				quit=true;
				break;
			}
		}
		}
	}
	public static void menuIntroduction() {
		System.out.println("1. 고객정보 확인하기 \t\t4. 바구니에 항목 추가하기");
		System.out.println("2. 장바구니상품 목록 보기 \t5. 장바구니의항목 수량 줄이기");
		System.out.println("3.장바구니 비우기 \t\t6. 장바구니의 항목 삭제하기");
		System.out.println("7.영수증 표시하기 \t\t8. 종료");
		System.out.println("**************************************");	
	}
	public static void menuGuestInfo(String name,int mobile) {  // int mobile로 변경
		System.out.println("현재 고객 정보:");
		//System.out.println("이름" + name + "\t연락처" + mobile);	
		Person Person = new Person(name,mobile);
		System.out.print("이름 "+name+ " 연락처" + mobile);
	}
	public static void menuCartItemList() {
		System.out.println("장바구니 상품 목록"); // 수정
		System.out.println("--------------------------------");
		System.out.println("   도서ID\t|      수량\t|      합계");
		for (int i = 0; i <mCartCount; i++) {
			System.out.println("    "+mCartItem[i].getBookID() +" \t| ");
			System.out.println("    "+mCartItem[i].getquantity() +" \t| ");
			System.out.println("    "+mCartItem[i].getTotalPrice());
			System.out.println("  ");
		}
		System.out.println("--------------------------------");
	}
	public static void menuCartClear() {
		System.out.println("3.장바구니 비우기");
	}
	public static void menuCartAddItem(String[][]book) {
		//System.out.println("4.장바구니 항목 추가하기");
		
		BookList(book);
		for(int i = 0; i < NUM_BOOK; i++) {
			for (int j = 0; j < NUM_ITEM; j++)
				System.out.print(book[i][j] +" | ");
			System.out.println(" ");
		}
			boolean quit = false;
			
			while(!quit) {
				System.out.print("장바구니에 추가할 도서의 ID를 입력하세요:");
				
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				
				boolean flag = false;			
				int numId = -1;
				
				for(int k = 0; k < NUM_BOOK; k++) {
					if(str.equals(book[k][0])) {
						numId = k;
						flag = true;
						break;
					}
					
				}
				if(flag) {
					System.out.println("장바구니에 추가하겠습니까? Y | N");
					str = input.nextLine();
					
					if(str.toUpperCase().equals("Y")){
						System.out.println(book[numId][0] + "도서가 장바구니에 추가되었습니다.");
						if(!isCartInbook(book[numId][0]))
							mCartItem[mCartCount++] = new CartItem(book[numId]);
						
					}
					quit = true;										
				}else
					System.out.println("다시 입력해 주세요");
				
			}
			
		}
	
	public static void menuCartRemoveItemCount() {
		System.out.println("5.장바구니 항목 수량 줄이기");	
	}
	public static void menuCartRemoveItem() {
		System.out.println("6.장바구니의 항목 삭제하기");		
	}
	public static void menuCartBill() {
		System.out.println("7.영수증 표시하기");		
	}
	public static void menuExit() {
		System.out.println("8.종료");		
	}
	public static void BookList(String[][] book) {
		
		book[0][0]="ISBN1234";
		book[0][1]="쉽게 배우는 JSP 웹 프로그래밍";
		book[0][2]="27000";
		book[0][3]="송미영";
		book[0][4]="단계별로 쇼핑물을 구혀하며 배우는 JSP 웹프로그래밍";
		book[0][5]="IT전문서";
		book[0][6]="2018/10/08";
		
		
		book[1][0]="ISBN1235";
		book[1][1]="안드로이드 프로그래밍";
		book[1][2]="33000";
		book[1][3]="우재남";
		book[1][4]="실습 단계별 명쾌한 멘토링!";
		book[1][5]="IT전문서";
		book[1][6]="2022/01/22";
		
		
		book[2][0]="ISBN1236";
		book[2][1]="스크래치";
		book[2][2]="22000";
		book[2][3]="고광일";
		book[2][4]="컴퓨팅 사고력을 키우는 블록 코딩";
		book[2][5]="컴퓨터입문";
		book[2][6]="2019/06/10";
		
		
		book[3][0]="ISBN1237";
		book[3][1]="HTML";
		book[3][2]="28000";
		book[3][3]="김민혁";
		book[3][4]="완성된 웹사이트로 배우는 HTML";
		book[3][5]="프론트 앤드 입문";
		book[3][6]="2023/04/15";
		
		
		book[4][0]="ISBN1238";
		book[4][1]="JAVA master";
		book[4][2]="18000";
		book[4][3]="홍길동";
		book[4][4]="자바 프로그래밍";
		book[4][5]="웹 프로그래밍";
		book[4][6]="2024/07/08";
				
	}
	
	public static boolean isCartInbook(String bookId) {
		boolean flag = false;
		for (int i = 0; i < mCartCount; i++) {
			if(bookId == mCartItem[i].getBookID()) {
				mCartItem[i].setQuantity(mCartItem[i].getquantity()+1);
				flag = true;
			}
		}
		return flag;
	}
	
	
			
}


