import { useState } from 'react'
import Post from './Post'
import { data } from './data'

const Posts = ({ posts, settingContent }) => {
  const getPost = (id) => {
    const post = posts.find((post) => post.id === id)
    console.log(post.information)
    settingContent(post.information)
  }

  return (
    <div className="posts">
      {posts.map((post) => {
        return <Post {...post} key={post.id} getPost={getPost} />
      })}
    </div>
  )
}
export default Posts
