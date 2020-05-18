<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



     </div><!-- .tbl-pay -->

                        <h3>결제 정보 
                                                </h3>
                                                <div class="tbl-order">
                                                    <table>
                                <caption>결제 정보</caption>
                                <colgroup>
                                    <col style="width: 110px">
                                    <col />
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <th scope="row"><div class="txt-l">결제방법</div></th>
                                        <td>
                                            <ul class="pay-method">
                                                                                            <li>
                <input type="radio" class="chk-rdo" name="radio_paymethod" value="PAYCO" checked='checked'/> 페이코(PAYCO)                 <em><span class="op-card-dc-price fc-red"></span></em>   </li>
                                                                                            <li>
                <input type="radio" class="chk-rdo" name="radio_paymethod" value="C" /> 신용카드                 <em><span class="op-card-dc-price fc-red"></span></em>   </li>
                                                                                            <li>
                <input type="radio" class="chk-rdo" name="radio_paymethod" value="D" /> 휴대폰 결제                 <em><span class="op-hp-dc-price fc-red"></span></em>   </li>
                                                                                            <li>
                <input type="radio" class="chk-rdo" name="radio_paymethod" value="V" /> 실시간 계좌이체                 <em><span class="op-bank-dc-price fc-red"></span></em>   </li>
                                                                                            <li>
                <input type="radio" class="chk-rdo" name="radio_paymethod" value="B" /> 무통장입금                 <em><span class="op-bank-dc-price fc-red"></span></em>             <select name="pay_data" class="w280 MK_bank_select_list MK_pay_add_choice"><option value=''>은행선택</option>                       <option value="국민은행 499402-01-195620 (예금주:김남승)" >국민은행 499402-01-195620 (예금주:김남승)</option>                       <option value="농협중앙회 356-0125-1995-93 (예금주:김남승)" >농협중앙회 356-0125-1995-93 (예금주:김남승)</option>                       <option value="우리은행 1002-650-368305 (예금주:김남승)" >우리은행 1002-650-368305 (예금주:김남승)</option>                       <option value="신한은행 110-408-157737 (예금주:김남승)" >신한은행 110-408-157737 (예금주:김남승)</option>                       <option value="하나은행 760-910218-13207 (예금주:김남승)" >하나은행 760-910218-13207 (예금주:김남승)</option>            </select>  </li>
                                                                                        </ul>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div><!-- .tbl-order -->
</body>
</html>



