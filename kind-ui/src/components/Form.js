import React from 'react';
import { StyleSheet, View, TextInput, Button } from 'react-native';
import axios from 'axios';

import ImagePickerExample from './ImagePicker';

export default class Form extends React.Component{

        constructor(props){
          super()
          this.state ={
            email:null,
            phoneNumber: null,
            description:null,
            image:null,
          }

        }


  imagePickerCallBack = (result) =>{
    this.setState({image:result});
  }

   dataURItoBlob = (dataURI) =>{
    var binary = window.atob(dataURI.split(',')[1]);
    var array = [];
    for(var i = 0; i < binary.length; i++) {
        array.push(binary.charCodeAt(i));
    }
    return new Blob([new Uint8Array(array)], {type: 'image/jpeg'});
}

  postFormData = () =>{
    let image = this.dataURItoBlob(this.state.image);
    let formData = new FormData();
    let adoptionRecord = 
      {
        "description": this.state.description,
        "emailAddress": this.state.email,
        "phoneNumber": this.state.phoneNumber
      }
    let adoptionRecordJsonFile = new Blob([JSON.stringify(adoptionRecord)],{type: 'application/json'});
    formData.append("adoptionRecord",adoptionRecordJsonFile);
    formData.append("document",image);

    // axios({
    //   method: "post",
    //   url: "http://localhost:8080/kind/adoptionRecord",
    //   data: formData,
     
    // })
    axios.post("http://localhost:8080/kind/adoptionRecord",formData)
      .then(function (response) {
        //handle success
        console.log(response);
      })
      .catch(function (response) {
        //handle error
        console.log(response);
      });


    }



  render(){
    console.log(this.state);
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
        <TextInput style={styles.input} placeholder="Enter Email Address" keyboardType="email-address" onChangeText={(text)=>this.setState({email:text})}/>
        <TextInput style={styles.input} placeholder="Enter phone number" keyboardType="phone-pad" onChangeText={(text)=>this.setState({phoneNumber:text})}/>
        <TextInput style={styles.input} placeholder="Desc" multiline={true} onChangeText={(text)=>this.setState({description:text})}/>
         <ImagePickerExample callBack={this.imagePickerCallBack}/> 
        <View >
        <Button 
          style={styles.button}
          title="Post"
          onPress={this.postFormData}
        />
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  button: {
    margin:10,
    elevation: 8,
    backgroundColor: "#009688",
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 12
  },
  input: {
    borderColor: "gray",
    width: "100%",
    borderWidth: 1,
    borderRadius: 10,
    padding: 10,
    margin:6
  },
});
