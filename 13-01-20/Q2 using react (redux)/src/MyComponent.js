import React from 'react'
import fruitName from './fruits.json'
import { connect } from 'react-redux'

class MyComponent extends React.Component{
	constructor(props){
		super(props);
		this.state = {
			data : fruitName,
			list : [],
			matched : [],
		};
	}
	displayFunction(item){
		// var temp = [];
		// console.log(item);
		// temp = this.state.list;
		// temp.push(item);
		// this.setState({list: temp});
		// console.log(this.state.list);
		this.props.saveClickedFruit('',item);
	}

	matchedFruit(e){
		var userinput = e.target.value;
		var temp1 = this.state.data;
		var temp2 = this.state.matched;
		var r1 = new RegExp(userinput);
		var r2 = new RegExp(userinput.toUpperCase());
		var r3 = new RegExp(userinput.toLowerCase());
		var temp3 = temp1.filter((item) => {
			if(r1.test(item)||r2.test(item)||r3.test(item)){
				return item;
			}
		});
		this.setState({matched: temp3});
	}

	render(){
		return(
			<div>
				<div style={{float:"left", display:"block", position:"relative", marginLeft: "150px" }}>
					<input type="text" placeholder="enter FRUIT to match..." onChange={this.matchedFruit.bind(this)}/>
					<div style={{color:"green"}}>
						<ul>
							{this.state.matched.map((fruit)=>(<li key={fruit}>{fruit}</li>))}

						</ul>
					</div>
					<ul style={{color:"blue",listStyle:"none"}}>
						{this.state.data.map((fruit)=>(<li onClick={()=>this.displayFunction(fruit)} key={fruit}>{fruit}</li>))}
					</ul>
				</div>
				<div style={{width:"550px",color:"red", float:"right", display:"block", position:"absolute",marginLeft:"500px"}}>
					<label>click on items to see selected fruits</label>
					<ul style={{listStyle:"none"}}>
						{this.state.list.map((item)=>(<li key={item}>{item}</li>))}						
					</ul>
				</div>	
			</div>
			)
	}
}

const copystate = (state) => {
	return {
		fruitsnames: state.fruit
	}
}

const copytoProps = (dispatch) => {
	return{
		saveClickedFruit: (name,val) => {dispatch({type:'CLICKED_FRUIT', [name]: val})}
	}
}

export default connect(copystate, copytoProps)(MyComponent);
