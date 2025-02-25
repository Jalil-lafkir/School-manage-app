
import SideBar from './Dash/SideBar';
import StatCards from './Dash/StatCards';


function Dashboard() {
  return (
    <div className='flex items-center justify-start flex-col'>
      <div className='text-[white] text-4xl font-bold px-7 my-12'>Admin Dashboard Overview</div>
      <StatCards/>
      <SideBar/>
    </div>
  )
}

export default Dashboard