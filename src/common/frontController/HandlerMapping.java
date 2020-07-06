package common.frontController;

import java.util.HashMap;

import com.market.board.controller.BoardController;
import com.market.index.controller.IndexController;
import com.market.member.controller.MemberController;
import com.market.member.controller.NoteController;
import com.market.service.controller.ServiceController;

import common.exception.Status404;

public class HandlerMapping {

	private HashMap<String, Controller> list = null;

	public HandlerMapping() {

		// 모든 컨트롤러 구현하려면 아래와같이 리스트에 넣을것. - Ryan

		list = new HashMap<String, Controller>();
		// 인덱스 페이지 및 기능들이 관리될 컨트롤러
		list.put("index", new IndexController());
		// 회원 관련된 페이지 및 기능들이 관리될 컨트롤러
		list.put("member", new MemberController());
		// 쪽지 관련 페이지 및 기능들이 관리될 컨트롤러
		list.put("note", new NoteController());
		// 게시판 성격을 가진 페이지 및 기능들이 관리될 컨트롤러
		list.put("board", new BoardController());
		// 고객센터 및 제공되는 서비스를 관리할 컨트롤러
		list.put("service", new ServiceController());

	}

	/**
	 * common.frontController HandlerMapping.java
	 * 
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO Controller 이름 URI 이름과 통일할 것
	 * 
	 * @param uriArr
	 * @return
	 * @throws Status404
	 */
	public Controller getController(String[] uriArr) throws Status404 {

		Controller res = list.get(uriArr[2]);
		if (res == null) {
			throw new Status404("uri를 다시 확인해주세요");
		}
		return res;
	}

	/**
	 * <pre>
	 * common.frontController
	 * HandlerMapping.java
	 * </pre>
	 * 
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO - 추가되는 기능 URI 와 Controller Method이름 통일할 것.
	 * 
	 * @param uriArr
	 * @return
	 * @throws Status404
	 */
	public String getMethod(String[] uriArr) throws Status404 {

		String methodName = "";

		switch (uriArr[2]) {
		case "index":
			switch (uriArr[3]) {
			case "index.do":
				methodName = "index";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;
		case "member":
			switch (uriArr[3]) {
			case "memberlogin.do":
				methodName = "memberLogin";
				break;
			case "memberjoin.do":
				methodName = "memberJoin";
				break;
			// 회원가입 매핑
			// servletBM에서 joinImple과 같음
			case "join.do":
				methodName = "join";
				break;
			// 아이디체크 매핑
			case "idcheck.do":
				methodName = "idCheck";
				break;
			case "nickcheck.do":
				methodName = "nickCheck";
				break;
			case "joinemailcheck.do":
				methodName = "joinEmailCheck";
				break;
			case "mypage.do":
				methodName = "myPage";
				break;
			case "mypagepw.do":
				methodName = "myPagePw";
				break;
			case "modify.do":
				methodName = "modify";
				break;
			case "login.do":
				methodName = "login";
				break;
			case "deleteinfo.do":
				methodName = "deleteInfo";
				break;
			case "mynoticelist.do":
				methodName = "myNoticeList";
				break;
			case "myrclist.do":
				methodName = "myRcList";
				break;
			case "myuclist.do":
				methodName = "myUcList";
				break;
			case "logout.do":
				methodName = "logOut";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;
		case "note":
			switch (uriArr[3]) {
			case "notebox.do":
				methodName = "noteBox";
				break;
			case "countnote.do":
				methodName = "countNote";
				break;
			case "countnotenoread.do":
				methodName = "countNoteNoRead";
				break;
			case "insertnote.do":
				methodName = "insertNote";
				break;
			case "receivenotebox.do":
				methodName = "receiveNoteBox";
				break;
			case "sendnotebox.do":
				methodName = "sendNoteBox";
				break;
			case "deletereceivenote.do":
				methodName = "deleteReceiveNote";
				break;
			case "deletesendnote.do":
				methodName = "deleteSendNote";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;
		case "board":
			// intro 페이지에서 Introduce.do/introKind.do/introInstructions.do의 더보기 클릭시 정보보여주는
			// 페이지로 이동해야된다.
			switch (uriArr[3]) {
			case "intro.do":
				methodName = "intro";
				break;
			case "introIntroduce.do":
				methodName = "introIntroduce";
				break;
			case "introKind.do":
				methodName = "introKind";
				break;
			case "introInstructions.do":
				methodName = "introInstructions";
				break;
				
			case "notice.do":
				methodName = "notice";
				break;
			case "noticedetail.do":
				methodName = "noticeDetail";
				break;
			case "noticelist.do":
				methodName = "noticeList";
				break;
				
			case "searchmarket.do":
				methodName = "searchMarket";
				break;
			case "marketinfo.do":
				methodName = "marketInfo";
				break;
				
			case "usedmarket.do":
				methodName = "usedList";
				break;
			case "useddetail.do":
				methodName = "usedDetail";
				break;
			case "usedWriter.do":
				methodName = "usedInsert";
				break;
			case "useddelete.do":
				methodName = "usedDelete";
				break;
			case "usedupload.do":
				methodName = "usedUpload";
				break;
				
			case "review.do":
				methodName = "reviewList";
				break;
			case "reviewdetail.do":
				methodName = "reviewDetail";
				break;
			case "reviewWriter.do":
				methodName = "reviewInsert";
				break;
			case "reviewdelete.do":
				methodName = "reviewDelete";
				break;
				
			case "reviewupload.do":
				methodName = "reviewUpload";
				break;
				
			case "selectreviewcom.do" :
				methodName = "rcSelect";
				break;
			case "insertreviewcom.do" :
				methodName = "rcInsert";
				break;
			case "editreview.do" :
				methodName = "editReview";
				break;
				
			case "selectusedcom.do" :
				methodName = "ucSelect";
				break;
			case "insertusedcom.do" :
				methodName = "ucInsert";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;
		case "service":
			switch (uriArr[3]) {
			case "support.do":
				methodName = "support";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요");
			}
			break;
		default:
			throw new Status404("uri를 다시 확인해주세요");
		}
		return methodName;
	}

}
