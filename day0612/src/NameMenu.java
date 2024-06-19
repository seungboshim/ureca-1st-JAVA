public class NameMenu {
    //데이터에 대한 CRUD

    //데이터 저장소
    String []names=new String[5];
//   String []names= {null,null,null,null,null};

    void create(String name){
        for(int i=0; i<names.length; i++) {
            if(names[i] == null){//빈곳 찾기
                names[i]=name;
                break;
            }
        }//for

    }//create


    String[] read(){
        return names;
    }
    void update(String oldName, String newName){
        for(int i=0; i<names.length; i++) {
            if (names[i].equals(oldName)) {
                // "==" 은 주소, 값 모두 같아야함
                // "equals" 메소드 써야함
                names[i] = newName;
                break;
            }
        }
    }
    void delete(String delName){
        for(int i=0; i<names.length; i++) {
            if (names[i].equals(delName)) {
                names[i] = null;
                break;
            }
        }
    }

}


