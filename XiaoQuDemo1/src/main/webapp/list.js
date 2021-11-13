
function selectAll(){
    var elementsByName = document.getElementsByName("uid");
    var flag=false;
    for(var i=0;i<elementsByName.length;i++) {
        if (elementsByName[i].checked){
            flag=true;
        }else {
            flag=false;
            break;
        }

    }
    if (flag===true){//已选中
        for(var i=0;i<elementsByName.length;i++) {
            elementsByName[i].checked=false
        }
    }else {
        for(var i=0;i<elementsByName.length;i++) {
            elementsByName[i].checked=true
        }
    }

}
function isSelect(){
    var elementsByName = document.getElementsByName("uid");
    for(var i=0;i<elementsByName.length;i++) {
        if (elementsByName[i].checked){
            elementsByName[i].checked=false;
        }else if(!elementsByName[i].checked) {
            elementsByName[i].checked=true;
        }

    }
}
function deleteAll(){
    var name = document.getElementsByName("uid");
    var itemStr="";
    var flag=false;
    for(var i=0;i<name.length;i++) {
        if(name[i].checked){
            flag=true;
            itemStr+=name[i].id+" ";
        }
    }
    if (flag===false){
        alert("未选中，请检查!");
    }else {

        if (confirm("您确定要删除"+itemStr+"吗")){
            document.getElementById("selectUser").submit();
            alert("删除成功!");
            //location.href = "/userListServlet";

        }
    }


}