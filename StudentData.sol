contract StudentData{
struct stud{
    uint roll;
    string name;

}

stud[] studentArray;

function AddStudent(string memory name,uint roll)public{

    studentArray.push(stud(roll,name));


}

function showData() public view returns(stud[] memory){
    return studentArray;

}

function getbyRollNo(uint rolln) public view returns(stud memory){

    for (uint i =0 ; i< studentArray.length;i++){

        if (studentArray[i].roll == rolln ){
            return studentArray[i];
        }
    }
    revert("Student Not Found");
}

fallback() external payable { 
    //ddd 
    }

receive() external payable { //ddd 
}



}