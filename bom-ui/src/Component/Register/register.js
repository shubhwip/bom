import React, { Component } from 'react'
export default class Register extends Component {
    render() {
        return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 col-offset-6'>
                    <form>
     <div class="form-group">
       <label for="exampleInputEmail1">Company Name</label>
       <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Company Name"/>
     </div>
     <div class="form-group">
            <label for="exampleInputEmail1">Company Email</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Company Email"/>
     </div>
     <div class="form-group">
            <label for="exampleInputEmail1">Maintainer</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Maintainer Name"/>
     </div>
     <div class="form-group">
            <label for="exampleInputEmail1">Version Control URL</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Version Control URL"/>
     </div>
     <button type="submit" class="btn btn-primary">Submit</button>
   </form>
   </div>
           </div>
   </div>
        )
    }
}
