import React from 'react';
import data from './data.json';
class NewComponent extends React.Component {
	constructor(props){
		super(props);
		this.state = {
			d: data,
			current_item: [],
			matched_item: []
		};
	}
	displayFunction(dt){
		console.log(dt);
		var temp =[]
		temp= this.state.current_item;
		temp.push(dt);
		console.log(temp)
		this.setState({current_item: temp});

		console.log(this.state.current_item);
	}
	matched(event_1) {
		//console.log(event_1.target.value);
		var input_val = event_1.target.value;
		//console.log(input_val);
		var temp1 = this.state.matched_item;
		var temp2 = this.state.d;
		var r1 = new RegExp(input_val);
		var r2 = new RegExp(input_val.toUpperCase());
		var r3 = new RegExp(input_val.toLowerCase());
		//temp2.forEach((item) => { if(reg.test(item.city)===true){ temp1.push(item)}});
		var temp3=temp2.filter((item) => {
			if(r1.test(item.city)||r2.test(item.city)||r3.test(item.city)){
				return item;
			}
		});
		console.log(temp3);
		this.setState({matched_item: temp3});

	}
	render(){
		const list = this.state.d;
		const clickedlist = this.state.current_item;
		const matched_item = this.state.matched_item;
		//console.log(current_item);
		return (
			<div>
				<div style={{float:"left", display:"block", position:"relative"}}>
					<p>Hello from Sheenam</p>
					<input type="text" placeholder="enter CITY to match..." onChange={this.matched.bind(this)}/>
					<div style={{color:"green"}}>
						<ul>
							{matched_item.map((city)=>(<li key={city.id}>{city.id}, {city.city} </li>))}
						</ul>
					</div>
					<ul style={{color:"blue"}}>
						{list.map((dt)=>(<li onClick={()=>this.displayFunction(dt)} key={dt.id}>{dt.id}. <b>{dt.city}</b> -> {dt.pollutant_id}, Station: {dt.station}</li>))}
					</ul>
				</div>
				<div style={{width:"550px",color:"red", float:"right", display:"block", position:"absolute",marginLeft:"700px"}}>
					<label>click on items to see min & max pollutant</label>
					<ul>
						{clickedlist.map((item)=>(<li key={item.id}>{item.id}  {item.city} -> Pollutant:<b>{item.pollutant_id}</b>  Min: {item.pollutant_min}, Max: {item.pollutant_max}, </li>))}
					</ul>
				</div>				
			</div>
		)
	}
}
export default NewComponent;
