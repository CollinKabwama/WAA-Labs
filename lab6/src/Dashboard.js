import { useState } from 'react'
import Posts from './Posts'
import { data } from './data'

const Dashboard = () => {
  const [content, setContent] = useState('ssss')
  const [posts, setPosts] = useState(data)
  const [inputValue, setInputValue] = useState('')

  const changeFirstTitle = () => {
    let newPosts = [...posts]

    // Modify the title of the first post in the new array
    newPosts[0] = { ...newPosts[0], title: inputValue }

    // Set the state with the new array
    setPosts(newPosts)
  }

  const handleInputChange = (event) => {
    setInputValue(event.target.value)
  }

  const settingContent = (values) => {
    setContent(values)
  }

  return (
    <div>
      <Posts posts={posts} settingContent={settingContent} />

      <input
        className="name"
        type="text"
        value={inputValue}
        name=""
        onChange={handleInputChange}
      />
      <button className="btn" onClick={changeFirstTitle}>
        Change Name
      </button>
      <div className="content">{content}</div>
    </div>
  )
}
export default Dashboard
