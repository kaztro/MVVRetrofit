package com.petrlr14.mvvm.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.petrlr14.mvvm.database.daos.GitHubDAO
import com.petrlr14.mvvm.database.entities.GitHubRepo

class GitHubRepoRepository (private val repoDao:GitHubDAO, private val githubService: GithubService){

    @WorkerThread
    suspend fun insert(repo:GitHubRepo){
        repoDao.insert(repo)
    }

    fun getAll():LiveData<List<GitHubRepo>>{
        return repoDao.getAllRepos()
    }

    @WorkerThread
    suspend fun nuke(){
        return repoDao.nukeTable()
    }

    @WorkerThread
    suspend fun nuke() = repoDao.nukeTable()

    fun retrieveReposAsync(user: String): Deferred<Response<List<GithubRepo>>> {
        return GithubService.getRepos(user)
    }


}