#!/bin/bash

function usage() {
  echo "Usage:"
  echo " copy_file.sh EntityName"
  echo "Example:"
  echo " copy_file.sh Teacher"
  exit -1
}
if [ $# != 1 ]; then
  usage;
fi

workdir=`pwd`
src_dir=${workdir}/service/generator/src/main/java/cn/geekhall/hera/server
dst_dir=${workdir}/service/edu/src/main/java/cn/geekhall/hera/server
resources_src_dir=${workdir}/service/generator/src/main/resources
resources_dst_dir=${workdir}/service/edu/src/main/resources
echo "Start copy "${1}
if [ -f $src_dir/controller/*${1}Controller.java ]; then
  echo "cp -rf $src_dir/controller/*${1}Controller.java $dst_dir/controller/"
  cp -rf $src_dir/controller/*${1}Controller.java $dst_dir/controller/
fi
if [ -f $src_dir/service/*${1}Service.java ]; then
  echo "cp -rf $src_dir/service/*${1}Service.java $dst_dir/service/"
  cp -rf $src_dir/service/*${1}Service.java $dst_dir/service/
fi

if [ -f $src_dir/service/impl/*${1}ServiceImpl.java ]; then
  echo "cp -rf $src_dir/service/impl/*${1}ServiceImpl.java $dst_dir/service/impl/"
  cp -rf $src_dir/service/impl/*${1}ServiceImpl.java $dst_dir/service/impl/
fi

if [ -f $src_dir/mapper/*${1}Mapper.java ]; then
  echo "cp -rf $src_dir/mapper/*${1}Mapper.java $dst_dir/mapper/"
  cp -rf $src_dir/mapper/*${1}Mapper.java $dst_dir/mapper/
fi

if [ -f $src_dir/entity/*${1}.java ]; then
  echo "cp -rf $src_dir/entity/*${1}.java $dst_dir/entity/"
  cp -rf $src_dir/entity/*${1}.java $dst_dir/entity/
fi

if [ -f $resources_src_dir/mapper/*${1}Mapper.xml ]; then
  echo "cp -rf $resources_src_dir/mapper/*${1}Mapper.xml $resources_dst_dir/mapper/"
  cp -rf $resources_src_dir/mapper/*${1}Mapper.xml $resources_dst_dir/mapper/
fi

