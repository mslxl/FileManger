package com.mslxl.filemanager.core

import com.mslxl.filemanager.core.api.BasePlugin
import com.mslxl.filemanager.core.api.annotation.Plugin
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.scanners.TypeAnnotationsScanner
import org.reflections.util.ConfigurationBuilder

object PluginLoader {

    private val pluginClassList = Reflections(
        ConfigurationBuilder().forPackages("")
            .setScanners(
                SubTypesScanner(),
                TypeAnnotationsScanner()
            )
    ).getTypesAnnotatedWith(Plugin::class.java)
        .toMutableSet()

    private val pluginInfo = pluginClassList
        .map { it.name to it.getDeclaredAnnotation(Plugin::class.java) }
        .toMap()
        .toMutableMap()
    private val pluginInstance = pluginClassList.map(
        PluginLoader::preLoad).toMutableSet()

    init {
        pluginInstance.forEach(BasePlugin::init)
        pluginInstance.forEach(BasePlugin::postInit)
    }

    fun getPluginInfoByName(name:String) = pluginInfo[name]!!


    private fun preLoad(clz: Class<*>): BasePlugin {
        val info = getPluginInfoByName(clz.name)
        //TODO Check whether depend is valid

        return (clz.newInstance() as BasePlugin).apply(BasePlugin::preInit)
    }

    internal fun getPluginInstanceByName(name: String):Any{
        return pluginClassList.find { it.name==name }!!
    }
    internal fun getPluginInstanceById(id:String):Any{
        val name = pluginInfo.entries.find { it.value.id == id }!!.key
        return getPluginInstanceByName(name)
    }

}